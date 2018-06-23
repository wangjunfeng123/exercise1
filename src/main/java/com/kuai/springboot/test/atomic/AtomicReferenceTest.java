package com.kuai.springboot.test.atomic;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc AtomicReference存在ABA问题，用AtomicStampedReference解决
 * @since ${date}
 */
public class AtomicReferenceTest {
    public static final AtomicStampedReference<String> ATOMIC_REFERENCE = new AtomicStampedReference<>("abc",0);
    private static final Random RANDOM_OBJECT = new Random();

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            final int num = i;
            threads[i] = new Thread(() -> {
                String oldValue = ATOMIC_REFERENCE.getReference();
                int stamp = ATOMIC_REFERENCE.getStamp();
                try {
                    countDownLatch.await();
                    Thread.sleep(RANDOM_OBJECT.nextInt() & 1000);
                } catch (InterruptedException e) {

                }
                if (ATOMIC_REFERENCE.compareAndSet(oldValue, oldValue + "sss" + num,stamp,stamp+1)) {
                    System.out.println("线程" + num + "进行了修改");
                    System.out.println("last result " + ATOMIC_REFERENCE.getReference());
                }
            });
            threads[i].start();
        }

        Thread.sleep(200);
        countDownLatch.countDown();
        new Thread(() -> {
            try {
                Thread.sleep(RANDOM_OBJECT.nextInt() & 200);
            } catch (InterruptedException e) {

            }
            int stampe = ATOMIC_REFERENCE.getStamp();
            while (!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.getReference(), "abc",stampe,stampe+1)) ;
            System.out.println("modify abc"+ ATOMIC_REFERENCE.getReference());
        }).start();
    }
}