package com.xiecj.cloud.auth.config;

import com.xiecj.cloud.common.handler.GlobalExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConfiguration {

    @Bean
    public GlobalExceptionHandler getGlobalExceptionHandler(){
        return  new GlobalExceptionHandler();
    }
}
