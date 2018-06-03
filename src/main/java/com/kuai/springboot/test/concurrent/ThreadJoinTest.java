package com.kuai.springboot.test.concurrent;

import java.util.Random;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ThreadJoinTest {
    static class Computer extends Thread {
        private int start;
        private int end;
        private int result;
        private int array[];

        public Computer(int start, int end, int[] array) {
            this.array = array;
            this.end = end;
            this.start = start;
        }

        public void run() {
            for (int i = start; i < end; i++) {
                result += array[i];
                if (result < 0) {
                    result &= Integer.MAX_VALUE;
                }
            }
        }
        public int getResult(){
            return result;
        }
    }


    private static final int COUNTER = 100000000;

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[COUNTER];
        Random random = new Random();
        for (int i = 0; i < COUNTER; i++) {
            array[i] = Math.abs(random.nextInt());
        }
        long start = System.currentTimeMillis();
        Computer c1 = new Computer(0,COUNTER/2,array);
        Computer c2 = new Computer(COUNTER/2,COUNTER,array);

        c1.start();
        c2.start();
        c1.join();
        c2.join();
        System.out.println(System.currentTimeMillis() - start);

        System.out.println((c1.getResult() + c2.getResult())&Integer.MAX_VALUE);
    }
}