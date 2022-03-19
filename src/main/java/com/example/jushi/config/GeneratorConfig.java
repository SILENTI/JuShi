package com.example.jushi.config;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * @author 居無何
 * date: 2022/3/18 17:55
 * Description:
 */
public class GeneratorConfig {

    public static void main(String[] args) {
        //需要修改的地方
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/jushi?useUnicode=true&characterEncoding=utf-8&useSSL=true&serverTimezone=UTC",
                        "root",
                        "root")
                .globalConfig(builder -> {
                    builder.author("居無何") // 设置作者
                            .enableSwagger() // 开启 swagger 模式
                            .disableOpenDir()   //禁止打开生成项目
                            .fileOverride()// 覆盖已生成文件
                            .commentDate("yyyy/MM/dd")
                            //需要修改的地方
                            .outputDir("E://PRPJECT//JavaEE//JuShi//src//main//java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    //需要修改的地方
                    builder.parent("com.example.jushi") // 设置父包名
                            .entity("model") //设置实体类包名
                            .service("service")
                            .serviceImpl("service.impl")
                            .mapper("mapper")
                            .xml("mapper.xml")
                            .controller("controller")
                            .moduleName("") // 设置父包模块名
                            //需要修改的地方
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "E://PRPJECT//JavaEE//JuShi//src//main//resources//mappers")) // 设置mapperXml生成路径
                    ;
                })
                .strategyConfig(builder -> {
                    builder.addInclude("seckill") // 设置需要生成的表名
                            .addTablePrefix("t_", "c_") // 设置过滤表前缀

                            .controllerBuilder() //开启controller层配置策略
                            .enableRestStyle() //开启RestController配置

                            .mapperBuilder() //开启mapper配置策略
                            .enableMapperAnnotation() //开启@Mapper注解配置
                            .enableBaseResultMap(); //开启resultMap生成

                })
                .templateEngine(new FreemarkerTemplateEngine())
                // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
    
}
