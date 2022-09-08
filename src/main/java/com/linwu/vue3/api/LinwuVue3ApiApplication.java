package com.linwu.vue3.api;

import com.linwu.vue3.api.utils.ApplicationContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class LinwuVue3ApiApplication extends SpringBootServletInitializer implements ApplicationContextAware {

  public static void main(String[] args) {
    SpringApplication.run(LinwuVue3ApiApplication.class, args);
    System.err.println("http://localhost:8080/doc.html");
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(LinwuVue3ApiApplication.class);
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    ApplicationContextUtil.setApplicationContext(applicationContext);
  }
}
