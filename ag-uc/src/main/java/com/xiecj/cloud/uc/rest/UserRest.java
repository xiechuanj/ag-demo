package com.xiecj.cloud.uc.rest;

import com.xiecj.cloud.common.context.BaseContextHandler;
import com.xiecj.cloud.common.rest.BaseController;
import com.xiecj.cloud.uc.biz.BaseUserBiz;
import com.xiecj.cloud.uc.entity.BaseUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserRest extends BaseController<BaseUserBiz,BaseUser> {
    @RequestMapping("/who")
    public String getCurrentUser(){
        return  BaseContextHandler.getUsername();
    }
//    @Autowired
//    private BaseUserBiz userBiz;
//
//    @RequestMapping("/{id}")
//    public BaseUser getByID(@PathVariable Integer id)   {
//        return  userBiz.selectByPrimaryKey(id);
//    }

//    @Value("${name}")
//    private String name;
//    @Value("${age}")
//    private String age;
//    @RequestMapping("/{id}")
//    public String octUserInfo(@PathVariable String id)   {
//        return name + ":" + age;
//    }
}
