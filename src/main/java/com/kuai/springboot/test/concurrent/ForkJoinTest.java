package com.kuai.springboot.test.concurrent;

import java.util.concurrent.RecursiveTask;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ForkJoinTest extends RecursiveTask {

    @Override
    protected Object compute() {
        return new Object();
    }
}