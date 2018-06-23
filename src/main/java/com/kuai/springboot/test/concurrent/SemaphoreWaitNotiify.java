package com.kuai.springboot.test.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class SemaphoreWaitNotiify {
    private static final int QUERY_MAX_LENGTH = 5;
    private static final int THREAD_COUNT = 20;
    private static final AtomicInteger NOW_CALL_COUNT = new AtomicInteger(0);
    private static final Object LOCK_OBJECT = new Object();


    public static void main(String[] args) {
        final Random random = new Random();
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread() {
                public void run() {
                    trToLock();
                    System.out.println(this.getName());
                }
            }.start();
        }
    }

    private static void trToLock() {
        int tryTimes = 0;
        int nowValue = NOW_CALL_COUNT.get();
        while (true) {
            if (nowValue < QUERY_MAX_LENGTH && NOW_CALL_COUNT.compareAndSet(nowValue, nowValue + 1)) {


            }
        }
    }
}