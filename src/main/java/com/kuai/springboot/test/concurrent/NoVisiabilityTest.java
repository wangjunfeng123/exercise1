package com.kuai.springboot.test.concurrent;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class NoVisiabilityTest {
    private static class ReadThread extends Thread {

        private volatile boolean ready;
        private int number;

        public void run() {
            while (!ready) {
                number++;
//                System.out.println(number);
            }
            System.out.println(ready);
        }

        public void readyOn() {
            this.ready = true;
        }
    }

    //主方法
    public static void main(String[] args) throws InterruptedException {
        ReadThread readThread = new ReadThread();
        readThread.start();
        Thread.sleep(200);
        readThread.readyOn();
        System.out.println(readThread.ready + "---");
    }

}