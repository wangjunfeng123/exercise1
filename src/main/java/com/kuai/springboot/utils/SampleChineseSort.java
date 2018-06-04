package com.kuai.springboot.utils;

import java.text.Collator;
import java.util.*;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc  中文拼音排序
 * @since ${date}
 */
public class SampleChineseSort {
    private static final Comparator CHINA_COMPARE= Collator.getInstance(Locale.CHINA);

    public static void main(String[] args){
        List<String> list = Arrays.asList("张三","李四","王五");
        sortList(list);
    }

    private static void sortList(List<String> list){
        Collections.sort(list,CHINA_COMPARE);
        for (String name:list) {
            System.out.println(name);
        }
    }


}