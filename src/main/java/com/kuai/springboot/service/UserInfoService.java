package com.kuai.springboot.service;


import com.kuai.springboot.domain.UserInfo;

public interface UserInfoService {

    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}