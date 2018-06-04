package com.kuai.springboot.test.java8;

import com.kuai.springboot.domain.Apple;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc lamda demo
 * @since ${date}
 */
public class TestJava {
    public  static void main(String[] args){
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(Comparator.comparing(Apple::getWeight));

    }
}