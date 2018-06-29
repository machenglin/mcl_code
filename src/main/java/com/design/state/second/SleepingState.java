package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class SleepingState extends State {
    @Override
    public void writeProgram(Work work) {
        System.out.println("当前时间：" + work.getHour() + "点睡着了");
    }
}
