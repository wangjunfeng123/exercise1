package com.kuai.springboot.test.invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class AOPHandler implements InvocationHandler {

    private Object target;

    public AOPHandler(Object target) {
        this.target = target;
    }

    //打印参数
    public void println(String str ,Object ... args){
        System.out.println(str);
        if (args == null){
            System.out.println("未传入任何参数");
        } else {
            for (Object obj:args) {
                System.out.println(obj);
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\t\t---调用方法名:"+method.getName());
        Class<?>[] variables = method.getParameterTypes();
        for (Class<?> typevariables:variables) {
            System.out.println("\t\t " + typevariables.getName());
        }
        println("传入的参数为");
        for (Object arg:args) {
            System.out.println("\t\t\t"+arg);
        }
        Object result = method.invoke(target, args);
        println("返回值为：",result);
        println("返回值数据类型",method.getReturnType());
        return result;
    }
}