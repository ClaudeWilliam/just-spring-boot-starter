package com.just.share.spring.boot.autoconfigure;

public class Print1 {

    enum ReadToRun {T1, T2}
    // int 1,0;

    static volatile ReadToRun r = ReadToRun.T1;

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "abcdefgh".toCharArray();
        new Thread(() -> {
            for (char c : aI) {
                while (r != ReadToRun.T1) {
                }
                System.out.println(c);
                r = ReadToRun.T2;
            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : aC) {
                while (r != ReadToRun.T2) {
                }
                System.out.println(c);
                r = ReadToRun.T1;
            }
        }, "t1").start();
    }
}
