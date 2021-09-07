package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.example.demo.Model")
public class Demo10Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo10Application.class, args);
    }

}
