package com.generics;

/**
 * 1、简单泛型
 * Created by MCL on 2018/1/21.
 */
public class Holder<T> {
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Holder<String> stringHolder = new Holder<>();
        stringHolder.setA("进击的马小林");
//        stringHolder.setA(1);// 编译报错
    }
}
