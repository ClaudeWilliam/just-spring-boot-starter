package com.just.share.spring.boot.autoconfigure;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class Print4 {

    public static void main(String[] args) {
        TransferQueue<Character> queue = new LinkedTransferQueue<>();
        char[] aI = "12345678".toCharArray();
        char[] aC = "abcdefgh".toCharArray();
        new Thread(() -> {
            try {
                for (char c : aC) {
                    System.out.println(queue.take());
                    queue.add(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : aI) {
                    queue.add(c);
                    System.out.println(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
