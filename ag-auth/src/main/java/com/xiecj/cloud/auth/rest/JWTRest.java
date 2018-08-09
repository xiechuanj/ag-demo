package com.xiecj.cloud.auth.rest;


import com.xiecj.cloud.auth.bean.UserInfo;
import com.xiecj.cloud.auth.jwt.JWTUtil;
import com.xiecj.cloud.auth.service.UserService;
import com.xiecj.cloud.common.vo.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("jwt")
public class JWTRest {
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/token",method = RequestMethod.POST)
    public ObjectRestResponse authorize(String username, String password) throws Exception {
        UserInfo info = userService.login(username, password);
        return  new ObjectRestResponse<String>().data(jwtUtil.generateToken(info));
    }
}
