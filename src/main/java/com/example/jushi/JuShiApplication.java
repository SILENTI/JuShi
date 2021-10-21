package com.example.jushi;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.jushi.mapper")
public class JuShiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JuShiApplication.class, args);
    }

}
