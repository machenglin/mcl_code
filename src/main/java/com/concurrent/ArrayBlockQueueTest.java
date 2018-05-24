package com.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by machenglin on 2018/3/29.
 */
public class ArrayBlockQueueTest {

    public static void main(String[] args) {
        ArrayBlockingQueue<String> arrayBlockQueue = new ArrayBlockingQueue<String>(1);
        arrayBlockQueue.offer("a");
        arrayBlockQueue.offer("b");
    }
}
