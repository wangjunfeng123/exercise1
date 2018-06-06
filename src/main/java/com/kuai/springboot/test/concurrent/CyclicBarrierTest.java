package com.kuai.springboot.test.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class CyclicBarrierTest {
    public static final int THREAD_COUNT = 3;

    private final static CyclicBarrier CYCLIC_BARRIER = new CyclicBarrier(
            THREAD_COUNT, () -> System.out.println("我是导游，本次点名结束==============")
    );

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(String.valueOf(i)){
                public void run() {
                    try {
                        System.out.println("我是线程"+ this.getName() +"我们去旅游吧");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程" + this.getName() + "我们开始骑车");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程" + this.getName() + "我们开始爬山");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程" + this.getName() + "我们去宾馆休息");
                        CYCLIC_BARRIER.await();
                        System.out.println("我是线程" + this.getName() + "我们回家了");
                        CYCLIC_BARRIER.await();
                    } catch (InterruptedException e) {

                    } catch (BrokenBarrierException e) {

                    }
                }
            }.start();
        }
    }
}