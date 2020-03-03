package com.just.share.spring.boot.autoconfigure;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Print3 {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();//队列 一个condition是一个线程队列
        char[] aI = "12345678".toCharArray();
        char[] aC = "abcdefgh".toCharArray();
        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aI) {
                    System.out.println(c);
                    condition.signalAll();
                    condition.await();
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.println(c);
                    condition.signalAll();
                    condition.await();
                }
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
