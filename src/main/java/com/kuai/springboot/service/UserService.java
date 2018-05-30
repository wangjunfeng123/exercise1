package com.kuai.springboot.service;

import com.kuai.springboot.domain.UserEntity;
import com.kuai.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserEntity getUser(long id) {
        return userMapper.getOne(id);
    }

    @Transactional
    public void save(UserEntity user) {
        userMapper.insert(user);

//        String bb = null;
//        bb.isEmpty(); 测试事务的回滚
    }
}