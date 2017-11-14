package design.strategy.simple;

import design.strategy.simple.CalPrice;

/**
 * Created by Mcl on 2017/11/13.
 */
public class GoldVip implements CalPrice {
    static final int minPrice = 3000;

    @Override
    public Double calPrice(Double originalPrice) {
        return originalPrice * 0.5;
    }
}
