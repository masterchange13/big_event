package com.mao.softwaredesigner1227;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {
    @Test
    public void testThreadLocal(){
        ThreadLocal tl = new ThreadLocal();

        // 开启两个线程
        new Thread(()->{
            tl.set("zyq");
            System.out.println(Thread.currentThread().getName() + " " + tl.get());
            System.out.println(Thread.currentThread().getName() + " " + tl.get());
            System.out.println(Thread.currentThread().getName() + " " + tl.get());
        }, "blue").start();

       new Thread(()->{
           tl.set("mao");
           System.out.println(Thread.currentThread().getName() + " " + tl.get());
           System.out.println(Thread.currentThread().getName() + " " + tl.get());
           System.out.println(Thread.currentThread().getName() + " " + tl.get());
       }, "green").start();
    }
}
