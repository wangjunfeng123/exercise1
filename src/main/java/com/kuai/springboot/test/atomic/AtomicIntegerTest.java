package com.kuai.springboot.test.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class AtomicIntegerTest {

    public static final AtomicInteger TEST_INTEGER = new AtomicInteger(1);
    private static int index = 1;

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch startDownLatch = new CountDownLatch(1);
        final Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread() {
                public void run() {
                    try {
                        startDownLatch.await();
                    } catch (InterruptedException e) {

                    }
                    for (int j = 0; j < 100; j++) {
                        index++;
                        TEST_INTEGER.incrementAndGet();
                    }
                }
            };
            threads[i].start();
        }
        Thread.sleep(100);
        startDownLatch.countDown();
        for (Thread t:threads) {
            t.join();
        }
        System.out.println("Atomic最终运行结果："+TEST_INTEGER.get());
        System.out.println("valatile 最终结果"  + index);
    }
}