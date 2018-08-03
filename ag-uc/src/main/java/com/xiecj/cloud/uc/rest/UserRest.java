package com.xiecj.cloud.uc.rest;

import com.xiecj.cloud.uc.biz.BaseUserBiz;
import com.xiecj.cloud.uc.entity.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRest {
    @Autowired
    private BaseUserBiz userBiz;

    @RequestMapping("/{id}")
    public BaseUser getByID(@PathVariable Integer id)   {
        return  userBiz.selectByPrimaryKey(id);
    }

//    @Value("${name}")
//    private String name;
//    @Value("${age}")
//    private String age;
//    @RequestMapping("/{id}")
//    public String octUserInfo(@PathVariable String id)   {
//        return name + ":" + age;
//    }
}
