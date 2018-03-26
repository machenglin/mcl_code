package com.concurrent.threadlocal;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * Created by Mcl on 2018/3/15.
 */
public class Number {
    private CustomThreadLocal customThreadLocal = new CustomThreadLocal(0);

    public void increase() throws InterruptedException {
        customThreadLocal.set(10);
        Thread.sleep(10);
        System.out.println("increase value : "+customThreadLocal.get());
    }

    public static void main(String[] args) {
        final Number number = new Number();
        new Thread (() -> {
            try {
                number.increase();
                number.increase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread (() -> {
            try {
                number.increase();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    private static class CustomThreadLocal{
        private Map<Long, Integer> cacheMap = Maps.newHashMap();
        @Getter
        @Setter
        private int defaultValue;

        public CustomThreadLocal(int defaultValue) {
            this.defaultValue = defaultValue;
        }
        public Integer get(){
            long id = Thread.currentThread().getId();
            if(cacheMap.containsKey(id)){
                return cacheMap.get(id);
            }
            return defaultValue;
        }
        public void set(int value){
            long id = Thread.currentThread().getId();
            cacheMap.put(id, value);
        }
    }
}
