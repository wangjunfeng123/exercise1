package com.kuai.springboot.service.impl;

import com.kuai.springboot.domain.UserInfo;
import com.kuai.springboot.mapper.UserInfoMapper;
import com.kuai.springboot.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo findByUsername(String username) {
        return userInfoMapper.findByUsername(username);
    }
}