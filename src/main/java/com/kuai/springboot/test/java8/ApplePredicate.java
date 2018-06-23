package com.kuai.springboot.test.java8;

import com.kuai.springboot.domain.Apple;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}