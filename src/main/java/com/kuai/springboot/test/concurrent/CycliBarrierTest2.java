package com.kuai.springboot.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc 优势：可以连续到达3次执行同一个任务
 */
public class CycliBarrierTest2 {
    private static final int COUNT = 3;

    public static final CyclicBarrier cyclicBarrier = new CyclicBarrier(COUNT, () -> System.out.println("集合，准备出发"));


    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            new Thread(String.valueOf(i)) {
                public void run() {
                    try {
                        System.out.println("我到了11" + this.getName());
                        cyclicBarrier.await();
                        System.out.println("我到了22" + this.getName());
                        cyclicBarrier.await();
                        System.out.println("我到了33" + this.getName());
                        cyclicBarrier.await();
                        System.out.println("我到了44" + this.getName());
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {

                    } catch (BrokenBarrierException e) {
                    }
                }
            }.start();
        }

    }
}