package com.xiecj.cloud.auth.service.impl;


import com.xiecj.cloud.auth.bean.UserInfo;
import com.xiecj.cloud.auth.exception.UserInvalidException;
import com.xiecj.cloud.auth.service.UserService;
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
