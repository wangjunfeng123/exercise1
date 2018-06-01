package com.kuai.springboot.test.invocation;

import java.lang.reflect.Proxy;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class BeanFactory {

    public static Object getBean(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = Class.forName(className).newInstance();
        AOPHandler aopHandler = new AOPHandler(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(), aopHandler);
    }

    public static<T> T getBean(String className,Class<T> clazz)
            throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (T) getBean(className);
    }
}