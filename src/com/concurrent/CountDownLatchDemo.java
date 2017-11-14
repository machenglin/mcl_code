package com.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * 应用场景：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行.
 * Created by Mcl on 2017/11/10.
 */
public class CountDownLatchDemo {

    private static int LATCH_SIZE = 5;
    private static CountDownLatch doneSignal;

    public static void main(String[] args) {

        doneSignal = new CountDownLatch(LATCH_SIZE);

        for (int i = 0; i < LATCH_SIZE; i++) {
            new InnerTread().start();
        }
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main await finished.");

    }

    static class InnerTread extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " sleep 1s");

                // 将CountDownLatch的数值减1
                doneSignal.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
