package com.xiecj.cloud.zuul.service.impl;

import com.xiecj.cloud.zuul.bean.UserInfo;
import com.xiecj.cloud.zuul.exception.UserInvalidException;
import com.xiecj.cloud.zuul.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class LocalUserService implements UserService {
    @Override
    public UserInfo login(String username, String password) {
        UserInfo localInfo = new UserInfo(username, "管理员","1", "123456");
        if (!localInfo.getPassword().equals(password)){
            throw new UserInvalidException("User Password Error");
        }
        return localInfo;
    }
}
