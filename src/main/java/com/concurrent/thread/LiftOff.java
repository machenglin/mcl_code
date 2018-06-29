package com.concurrent.thread;

/**
 * Created by machenglin on 2018/3/26.
 */
public class LiftOff implements Runnable {
    private int countDown = 10;
    private static int taskId = 0;
    private final int id = taskId++;

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(
                    new StringBuilder().append("#").append(id).append("(")
                            .append(countDown > 0 ? countDown : "Liftoff!")
                            .append(")").toString()
            );
//            Thread.yield();
        }
    }

    public static void main(String[] args) {
//        new Thread(new LiftOff()).start();
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
    }
}
