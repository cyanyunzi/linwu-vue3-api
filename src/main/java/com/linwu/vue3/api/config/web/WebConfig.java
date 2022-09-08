package com.linwu.vue3.api.config.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
  @Qualifier("myObjectMapper")
  @Autowired
  private ObjectMapper objectMapper;


  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    registry
            .addResourceHandler("swagger-ui.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    registry
            .addResourceHandler("/webjars/**")
            .addResourceLocations("classpath:/META-INF/resources/webjars/");
    registry.addResourceHandler("doc.html")
            .addResourceLocations("classpath:/META-INF/resources/");
    super.addResourceHandlers(registry);
  }

  @Override
  protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    super.configureMessageConverters(converters);
  }

  @Override
  protected void addFormatters(FormatterRegistry registry) {
    DateTimeFormatterRegistrar dateRegist = new DateTimeFormatterRegistrar();
    dateRegist.setDateFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    dateRegist.setTimeFormatter(DateTimeFormatter.ofPattern("HH:mm:ss"));
    dateRegist.setDateTimeFormatter(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    dateRegist.registerFormatters(registry);
  }
}
