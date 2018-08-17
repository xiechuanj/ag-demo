package com.xiecj.cloud.uc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@MapperScan("com.xiecj.cloud.uc.mapper")
@ComponentScan("com.xiecj.cloud.uc")
@EnableTransactionManagement
public class UcServer {

    public static void main(String[] args){
        SpringApplication.run(UcServer.class, args);
    }
}
