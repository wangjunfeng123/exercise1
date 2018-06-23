package com.kuai.springboot.service;

import com.kuai.springboot.domain.UserInfo;
import com.kuai.springboot.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    public UserInfo findByUsername(String username) {
        return userInfoMapper.findByUsername(username);
    }
}