package com.kuai.springboot.test.concurrent;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author wangjunfeng
 * @version 1.0
 * @desc The type Sale menu service.
 * @since ${date}
 */
public class TestLock {

    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

    public ReentrantReadWriteLock getReentrantReadWriteLock() {
        return reentrantReadWriteLock;
    }

    public static void main(String[] args) {
        A a = new A();
        a.writeLock();
        a.readLock();

    }

    static class A extends ReentrantReadWriteLock {

    }

}