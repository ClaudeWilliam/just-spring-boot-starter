package com.just.share.spring.boot.autoconfigure;

import java.util.concurrent.locks.LockSupport;

public class Print {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] aI = "12345678".toCharArray();
        char[] aC = "abcdefgh".toCharArray();
        t1=new Thread(()->{
            for(char c :aI){
                System.out.println(c);
                LockSupport.unpark(t2);//叫醒t2
                LockSupport.park(t1);//阻塞t1
            }
        },"t1");

        t2=new Thread(()->{
            for(char c :aC){
                LockSupport.park();//阻塞t2
                System.out.println(c);
                LockSupport.unpark(t1);//叫醒t1

            }
        },"t1");

        t1.start();
        t2.start();
    }
}
