package com.xiecj.cloud.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.xiecj.cloud.auth")
@MapperScan("com.xiecj.cloud.auth.mapper")
public class AuthlServer {

    public static void main(String[] args){
        SpringApplication.run(AuthlServer.class, args);
    }
}
