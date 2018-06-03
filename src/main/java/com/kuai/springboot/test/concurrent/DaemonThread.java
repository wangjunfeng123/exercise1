package com.kuai.springboot.test.concurrent;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class DaemonThread {
    private static final Object object = new Object();

    static class ThreadA extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println("start......");
                Thread.currentThread().suspend();
                System.out.println("end.....");

                int i = 1;
                while (true) {
                    System.out.println(i++);
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        a.setDaemon(true);
        a.start();

        Thread.sleep(100);
        System.out.println(a.getState());
        a.resume();
    }
}