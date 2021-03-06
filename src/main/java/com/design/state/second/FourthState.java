package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class FourthState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinish()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println("当前时间：" + work.getHour() + "点加班，疲累之极");
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
