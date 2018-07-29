package com.xiecj.cloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.xiecj.cloud.uc.mapper")
public class UcServer {

    public static void main(String[] args){
        SpringApplication.run(UcServer.class, args);
    }
}
