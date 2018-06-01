package com.kuai.springboot.test.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class TestMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        List<HashMap<String, String>> list = Arrays.asList(
                new HashMap<String, String>() {
                    {
                        put("name", "zhangsan");
                        put("title", "lisi");
                    }
                },
                new HashMap<String, String>(){
                    {
                        put("name", "xiaoyinzai");
                        put("title", "lp");
                    }
                }
                );

        List<UserDo> users = new ArrayList<UserDo>(list.size());
        for (HashMap<String,String> map:list) {
            users.add(ConvertionService.convertionToBean(map,UserDo.class));
        }
        System.out.println(users.toString());
    }
}