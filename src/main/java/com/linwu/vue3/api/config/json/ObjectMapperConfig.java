package com.linwu.vue3.api.config.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：林雾
 * @date ：2020/12/21
 * @description :
 */
@Configuration
public class ObjectMapperConfig {

  @Primary
  @Bean("myObjectMapper")
  public ObjectMapper test() {

    ObjectMapper objectMapper = new ObjectMapper();

    Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
    builder.serializationInclusion(JsonInclude.Include.ALWAYS);
    SimpleModule simpleModule = new SimpleModule();
    // Long转String
    simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
    // 忽略 transient 修饰的属性
    objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    objectMapper.registerModule(new Jdk8Module());
    JavaTimeModule module = new JavaTimeModule();
    module.addDeserializer(
            LocalDateTime.class,
            new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    module.addSerializer(
            LocalDateTime.class,
            new MyLocalDateTimeJsonSerializer());

    module.addDeserializer(
            LocalDate.class,
            new LocalDateDeserializer(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    module.addSerializer(
            LocalDate.class,
            new MyLocalDateJsonSerializer());
    module.addDeserializer(
            LocalTime.class,
            new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss")));
    module.addSerializer(
            LocalTime.class,
            new LocalTimeSerializer(DateTimeFormatter.ofPattern("HH:mm:ss")));

    objectMapper.registerModules(module,simpleModule);
    return objectMapper;
  }
}
