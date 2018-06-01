package com.kuai.springboot.test.invocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class TestMain {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        WorldInterface hello = BeanFactory.getBean(
                "com.kuai.springboot.test.invocation.WorldImpl",WorldInterface.class);
        hello.sleep("睡到自然醒");


        System.out.println("===============");
        Method me = HelloInterface.class.getDeclaredMethod("bye", String.class);
        me.invoke(new HelloImpl(), "zhangsan");

        System.out.println("===============");
        Method method = HelloInterface.class.getDeclaredMethod("bye", String.class);
        method.invoke(new WorldImpl(), "zhangsan");



    }
}