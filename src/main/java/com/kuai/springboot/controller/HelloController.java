package com.kuai.springboot.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@Api("hello 模块")
@RestController
@Scope("protptype")
public class HelloController {

    @Value("${com.neo.title}")
    private String title;

    @ApiOperation(value = "huanyingye")
    @RequestMapping("hello")
    public String welcome(){
        return "Hello World";
    }

    @RequestMapping("testProperty")
    public String testProperty(){

        return "test Property"+title;
    }
}