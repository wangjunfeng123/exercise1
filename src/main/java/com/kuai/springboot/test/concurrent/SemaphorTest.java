package com.kuai.springboot.test.concurrent;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class SemaphorTest {

    public static final int COUNT = 5;
    public static Semaphore semaphore = new Semaphore(COUNT);

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            new Thread() {
                public void run() {
                    boolean acquire = false;
                    try {
                        semaphore.acquire();
                        acquire = true;
                        System.out.println("wo huode le shiyongquan " + this.getName());
                        Thread.sleep(random.nextInt() % 1000 + 1000);
                        System.out.println("wo shiqu le shiyongquan ---" + this.getName());

                    } catch (InterruptedException e) {

                    }finally {
                        if (acquire) {
                            semaphore.release();
                        }
                    }

                }
            }.start();

        }

    }
}