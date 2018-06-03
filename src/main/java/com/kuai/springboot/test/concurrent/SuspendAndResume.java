package com.kuai.springboot.test.concurrent;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class SuspendAndResume {
    private static final Object object = new Object();

    static class ThreadA extends Thread{
        public void run(){
            synchronized (object) {
                System.out.println("start......");
                Thread.currentThread().suspend();
                System.out.println("end.....");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadA a = new ThreadA();
        ThreadA b = new ThreadA();
        a.start();
        b.start();

        Thread.sleep(100);
        System.out.println(a.getState());
        System.out.println(b.getState());
        a.resume();
        Thread.sleep(100);
        a.resume();
    }
}