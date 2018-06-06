package com.kuai.springboot.service;


import com.kuai.springboot.domain.UserInfo;
import org.springframework.stereotype.Service;

/**
 *  用户信息
 */
@Service
public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}