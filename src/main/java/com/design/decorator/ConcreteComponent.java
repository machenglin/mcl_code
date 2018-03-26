package com.design.decorator;

/**
 * Created by Mcl on 2018/3/15.
 */
public class ConcreteComponent implements Component {
    @Override
    public void method() {
        System.out.println("原来的方法");
    }
}
