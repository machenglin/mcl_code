package com.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * 后台线程
 * Created by machenglin on 2018/3/26.
 */
public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            System.out.printf("error");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i =0;i<10;i++){
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all thread start.......");
        TimeUnit.MILLISECONDS.sleep(250);
    }
}
