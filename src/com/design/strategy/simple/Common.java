package com.design.strategy.simple;

/**
 * Created by Mcl on 2017/11/13.
 */
public class Common implements CalPrice {
    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice;
    }
}
