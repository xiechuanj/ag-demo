package com.xiecj.cloud.zuul.service;

import com.xiecj.cloud.zuul.bean.UserInfo;

public interface UserService {
    UserInfo login(String username, String password);
}
