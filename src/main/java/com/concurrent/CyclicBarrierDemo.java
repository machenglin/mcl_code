package com.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 允许一组线程互相等待，直到到达某个屏障点。
 * Created by Mcl on 2017/11/10.
 */
public class CyclicBarrierDemo {
    private static int SIZE = 5;
    private static CyclicBarrier cyclicBarrier;

    public static void main(String[] args) {
        cyclicBarrier = new CyclicBarrier(SIZE);
        for (int i = 0; i < SIZE; i++) {
            new InnerThread().start();
        }

    }

    static class InnerThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " wait for CyclicBarrier.");
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " continued.");
        }
    }
}
