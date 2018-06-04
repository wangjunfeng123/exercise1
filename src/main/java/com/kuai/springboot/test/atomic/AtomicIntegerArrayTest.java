package com.kuai.springboot.test.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class AtomicIntegerArrayTest {
    public static final AtomicIntegerArray ATOMIC_INTEGER_ARRAY = new AtomicIntegerArray(10);

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            final int index = i % 100;
            final int threadNum = i;
            threads[i] = new Thread() {
                public void run() {
                    int result = ATOMIC_INTEGER_ARRAY.addAndGet(index, index + 1);
                    System.out.println("线程编号为：" + threadNum+
                            ",对应的原始值为："+(index+1)+",增加后的结构为："+result);

                }
            };
            threads[i].start();
        }
     }
}