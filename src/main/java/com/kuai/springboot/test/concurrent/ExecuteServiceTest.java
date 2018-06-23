package com.kuai.springboot.test.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ExecuteServiceTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(2);


        executorService.execute(new Task());

    }

    static class Task implements Runnable{
        @Override
        public void run() {
            System.out.println("task execute now");
        }
    }


}