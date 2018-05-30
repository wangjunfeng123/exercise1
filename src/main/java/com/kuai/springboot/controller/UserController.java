package com.kuai.springboot.controller;

import com.kuai.springboot.domain.UserEntity;
import com.kuai.springboot.domain.enums.UserSexEnum;
import com.kuai.springboot.mapper.UserMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@RestController
public class UserController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping("/user")
    public String user(){
        UserEntity user = new UserEntity();
        user.setNickName("zhangsan");
        user.setPassword("11111");
        user.setUserName("zhangsanss");
        user.setUserSex(UserSexEnum.MAN);

        userMapper.insert(user);
        return "insert";
    }
}