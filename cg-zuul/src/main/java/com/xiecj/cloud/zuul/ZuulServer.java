package com.xiecj.cloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableZuulServer
@ComponentScan("com.xiecj.cloud.zuul")
@EnableFeignClients
public class ZuulServer {

    public static void main(String[] args){
        SpringApplication.run(ZuulServer.class, args);
    }
}
