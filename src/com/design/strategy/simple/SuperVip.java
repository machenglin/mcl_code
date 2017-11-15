package com.design.strategy.simple;

/**
 * Created by Mcl on 2017/11/13.
 */
public class SuperVip implements CalPrice {
    static final int minPrice = 2000;
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.7;
    }
}
