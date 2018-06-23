package com.kuai.springboot.test.java8;

import com.kuai.springboot.domain.Apple;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class AppleColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equals("GREEN");
    }
}