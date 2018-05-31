package com.kuai.springboot.test.invocation;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        HelloInterface hello = BeanFactory.getBean(
                "com.kuai.springboot.test.invocation.HelloImpl",HelloInterface.class);
        hello.sleep("睡到自然醒");
    }
}