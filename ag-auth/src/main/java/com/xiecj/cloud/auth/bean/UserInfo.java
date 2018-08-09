package com.xiecj.cloud.auth.bean;

import com.xiecj.cloud.common.util.jwt.IJWTInfo;

public class UserInfo implements IJWTInfo {
    String username;
    String name;
    String userId;
    String password;
    String sex;
    int age;

    public UserInfo() {

    }

    public UserInfo(String username, String name, String userId, String password) {
        this.username = username;
        this.name = name;
        this.userId = userId;
        this.password = password;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String getUniqueName() {
        return username;
    }

    @Override
    public String getId() {
        return userId;
    }

    @Override
    public String getName() {
        return name;
    }
}
