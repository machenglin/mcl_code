package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class FirstState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println("当前时间" + work.getHour() + "点，上午工作，精神百倍");
        } else {
            work.setState(new SecondState());
            work.writeProgram();
        }
    }
}
