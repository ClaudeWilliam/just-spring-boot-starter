package com.just.share.spring.boot.autoconfigure;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static AtomicInteger race = new AtomicInteger(0);
    public static void increase(){
        race.incrementAndGet();
    }
    private static final int THREAD_COUCNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUCNT];
        for (int i = 0; i < THREAD_COUCNT; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            threads[i].start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(race.get());
    }
}
