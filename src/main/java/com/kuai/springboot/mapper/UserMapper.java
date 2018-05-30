package com.kuai.springboot.mapper;

import com.kuai.springboot.domain.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@Repository
public interface UserMapper {

        List<UserEntity> getAll();
        UserEntity getOne(Long id);
        void insert(UserEntity user);
        void update(UserEntity user);
        void delete(Long id);
}