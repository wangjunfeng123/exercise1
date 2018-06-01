package com.kuai.springboot.test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ConvertionService {
    public static<T> T convertionToBean(Map<String ,String> row,Class<T> clazz)
            throws IllegalAccessException, InstantiationException {

        //先获取实例
        Object object = clazz.newInstance();
        //获取这个类的属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            //如果属性是static 、final修饰，无法赋值
            if (!Modifier.isFinal(field.getModifiers())
                    &&  !Modifier.isStatic(field.getModifiers())) {

                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                //获取当前属性的注解
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation != null) {
                    //通过annotation 注解的名称来获取对应的值
                    String value = row.get(columnAnnotation.name());
                    Class<?> fieldType = field.getType();
                    if (fieldType == String.class) {
                        field.set(object,value);
                    } else if (fieldType == Integer.class) {
                        field.set(object,Integer.valueOf(value));
                    }
                    //more type used you need
                }
            }
        }
        return (T) object;
    }
}