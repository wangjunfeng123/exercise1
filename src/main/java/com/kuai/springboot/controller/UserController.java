package com.kuai.springboot.controller;

import com.kuai.springboot.domain.UserEntity;
import com.kuai.springboot.domain.enums.UserSexEnum;
import com.kuai.springboot.mapper.UserMapper;
import com.kuai.springboot.result.ApiResponse;
import com.kuai.springboot.result.ErrorType;
import com.kuai.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @RequestMapping("/user")
    public String user() {
        UserEntity user = new UserEntity();
        user.setNickName("zhangsan");
        user.setPassword("2222222222");
        user.setUserName("zhangsanss");
        user.setUserSex(UserSexEnum.WOMAN);
        userService.save(user);

        return "insert";
    }

    @RequestMapping(value = "/getUserById")
    public Map<String, Object> getUserById(long id) {
        try {
            logger.info("UserController getUserById id:{}", id);
            if (id < 0) {
                return ApiResponse.createFailMsgResult("参数错误");
            }
            UserEntity user = userService.getUser(id);
            return ApiResponse.createSuccessResult(user);
        } catch (Exception e) {
            logger.error("UserController getUserById id:{}", id, e);
            return ApiResponse.createFailMsgResult(ErrorType.COMMON_ERROR, "获取用户信息错误");
        }
    }
}