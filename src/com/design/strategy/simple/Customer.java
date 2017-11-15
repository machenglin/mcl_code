package com.design.strategy.simple;

/**
 * 相当于策略模式类图中的Context:
 * 1、持有抽象策略的接口
 * 2、具体的策略由简单工厂模式创建（扩展）
 * Created by Mcl on 2017/11/13.
 */
public class Customer {
    private Double totalAmount = 0D;
    private Double amount = 0D;
    private CalPrice calPrice = new Common();

    public void buy(Double amount){
        this.amount = amount;
        totalAmount += amount;
        calPrice = CalPriceFactory.createCalPrice(this);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public CalPrice getCalPrice() {
        return calPrice;
    }

    public void setCalPrice(CalPrice calPrice) {
        this.calPrice = calPrice;
    }

    public Double calLastAmount(){
        return calPrice.calPrice(amount);
    }
}
