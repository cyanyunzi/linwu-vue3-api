package com.linwu.vue3.api.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MybatisPlusGeneratorUtil {
  public static void main(String[] args) {
      FastAutoGenerator.create("jdbc:mysql://localhost:3306/linwu-vue3", "root", "root")
              .globalConfig(builder -> {
                  builder.author("linwu") // 设置作者
                          .enableSwagger() // 开启 swagger 模式
                          .fileOverride() // 覆盖已生成文件
                          .outputDir("/Users/zhanglei/code/generator"); // 指定输出目录
              })
              .packageConfig(builder -> {
                  builder.parent("com.linwu.vue3.api") // 设置父包名
                          .moduleName("") // 设置父包模块名
                          .pathInfo(Collections.singletonMap(OutputFile.xml, "/Users/zhanglei/code/generator")); // 设置mapperXml生成路径
              })
              .strategyConfig(builder -> {
                  builder.addInclude("dict") // 设置需要生成的表名
                          .addTablePrefix("", ""); // 设置过滤表前缀
              })
              .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
              .execute();
  }
}
