package com.xiecj.cloud.uc.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("uc")
public class UserRest {
    @Value("${name}")
    private String name;
    @Value("${age}")
    private String age;
    @RequestMapping("/{id}")
    public String octUserInfo(@PathVariable String id)   {
        return name + ":" + age;
    }
}
