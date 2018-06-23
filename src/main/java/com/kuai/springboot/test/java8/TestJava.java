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
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.sort(Comparator.comparing(Apple::getWeight));
        filterGreenApples(new ArrayList<Apple>());

        filterApples(inventory,new AppleHeavyPredicate());

    }

    //只找出绿色的苹果
    private static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if ("GREEN".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    //根据颜色找苹果
    private static List<Apple> filterColorApples(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (color.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    private static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}