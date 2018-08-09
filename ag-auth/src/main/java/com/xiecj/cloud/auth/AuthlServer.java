package com.xiecj.cloud.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.xiecj.cloud.auth")
public class AuthlServer {

    public static void main(String[] args){
        SpringApplication.run(AuthlServer.class, args);
    }
}
