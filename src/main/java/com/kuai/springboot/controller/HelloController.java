package com.kuai.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
@RestController
public class HelloController {

    @Value("${com.neo.title}")
    private String title;

    @RequestMapping("hello")
    public String welcome(){
        return "Hello World";
    }

    @RequestMapping("testProperty")
    public String testProperty(){

        return "test Property"+title;
    }
}