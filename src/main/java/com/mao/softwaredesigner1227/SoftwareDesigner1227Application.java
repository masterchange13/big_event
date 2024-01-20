package com.mao.softwaredesigner1227;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan("com.mao.softwaredesigner1227.mapper")
@SpringBootApplication
public class SoftwareDesigner1227Application {

    public static void main(String[] args) {
        SpringApplication.run(SoftwareDesigner1227Application.class, args);
    }

}
