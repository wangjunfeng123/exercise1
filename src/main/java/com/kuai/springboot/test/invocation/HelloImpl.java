package com.kuai.springboot.test.invocation;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class HelloImpl implements HelloInterface {
    @Override
    public void hello() {
        System.out.println("hello");
    }

    @Override
    public String talk() {
        System.out.println("talk");
        return "talk";
    }

    @Override
    public void bye(String message) {
        System.out.println("bye message");
    }

    @Override
    public String sleep(String message) {
        System.out.println("sleep message");
        return "sleep"+ message;
    }
}