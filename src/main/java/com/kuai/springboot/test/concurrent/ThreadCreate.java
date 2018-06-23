package com.kuai.springboot.test.concurrent;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ThreadCreate {

    public static void main(String[] args) {

        new Thread() {
            public void run() {
                System.out.println("thread created");
                System.out.println(this.getName());
                yield();
                try {
                    this.wait();
                } catch (InterruptedException e) {

                }
                System.out.println(this.getState()+"ddddd");
            }
        }.start();

        System.out.println(new Create().getState()+"llllllllllllllll");
        new Create().start();

        new Thread(new Runn()){
//            public void run() {
//                System.out.println("aaaaaaaaaaaaaaaa");
//                System.out.println("======="+this.getName());
//            }
        }.start();

        //第三个线程
        new Create().start();


        System.out.println("ttttttttt");
    }


    static class Create extends Thread {
        public void run() {
            System.out.println("create created");
            System.out.println(this.getName());
            System.out.println(this.getId());
        }
    }

    static class Runn implements Runnable {

        @Override
        public void run() {
            System.out.println("runn thread");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getId());
        }
    }

}