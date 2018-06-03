package com.kuai.springboot.test.concurrent;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class ThreadStackTest {
    public static void main(String[] args) {
        printStack(getStackByThread());
        printStack(getStackByException());
    }

    private static void printStack(StackTraceElement[] stacks) {
        for (StackTraceElement stack : stacks) {
            System.out.println(stack);
        }
        System.out.println("\n");
    }

    private static StackTraceElement[] getStackByException() {
        return new Exception().getStackTrace();

    }

    private static StackTraceElement[] getStackByThread() {
        return Thread.currentThread().getStackTrace();
    }
}
