package com.design.singleton;

/**
 * 单例模式：静态内部类的实现方式
 * Created by Mcl on 2017/11/9.
 */
public class Singleton {
    private Singleton() {
    }

    private static class SingletonInner {
        private static Singleton singleton = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInner.singleton;
    }

    public static void main(String[] args) {
        System.out.println(Singleton.getInstance());
    }
}
