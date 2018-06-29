package com.design.builder;

/**
 * Created by machenglin on 2018/5/17.
 */
public class Director {
    public void contruct(Builder builder) {
        builder.buildPartA();
        builder.buildPartB();
    }
}
