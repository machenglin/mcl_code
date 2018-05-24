package com.design.builder;

import com.clearspring.analytics.util.Lists;

import java.util.List;

/**
 * Created by machenglin on 2018/5/17.
 */
public class Product {

    private List<String> parts = Lists.newArrayList();

    public void add(String part) {
        parts.add(part);
    }

    public void show(){
        parts.forEach(System.out::println);
    }

}
