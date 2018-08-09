package com.xiecj.cloud.auth.service;


import com.xiecj.cloud.auth.bean.UserInfo;

public interface UserService {
    UserInfo login(String username, String password);
}
