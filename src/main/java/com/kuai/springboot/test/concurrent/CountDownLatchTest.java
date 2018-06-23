package com.kuai.springboot.test.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc countDownLatch 测试-- 这是一个交替阻塞的情况
 * @since ${date}
 */
public class CountDownLatchTest {
    private static final int GROUP_SIZE = 5;
    private static final Random random = new Random();

    public static void main(String[] args) {
        processOneGroup("分组1");
    }

    private static void processOneGroup(final String groupName) {

        final CountDownLatch preCountDown = new CountDownLatch(GROUP_SIZE);
        final CountDownLatch startCountDown = new CountDownLatch(1);
        final CountDownLatch endCountDown = new CountDownLatch(GROUP_SIZE);
        System.out.println("=======>\n 分组：" + groupName + "game start");

        for (int i = 0; i < GROUP_SIZE; i++) {
            new Thread(String.valueOf(i)) {
                public void run() {
                    preCountDown.countDown();
                    System.out.println("我是线程" + groupName + this.getName() + " num is ready");
                    try {
                        startCountDown.await();
                    } catch (InterruptedException e) {

                    }
                    try {
                        Thread.sleep(Math.abs(random.nextInt()) % 1000);
                    } catch (InterruptedException e) {

                    }
                    System.out.println("我是线程:" + groupName + "跑完了");
                    endCountDown.countDown();
                }
            }.start();
        }
        try {
            preCountDown.await();
            //执行过来，主线程会先阻塞到这儿，当preCountDown 为0时，继续往下执行
            //await 会阻塞当前线程，知道preCountDown变为0
        } catch (InterruptedException e) {

        }
        System.out.println("各就位  预备");
        startCountDown.countDown();
        try {
            endCountDown.await();
        } catch (InterruptedException e) {

        }
        System.out.println(groupName + "比赛结束");
    }
}
