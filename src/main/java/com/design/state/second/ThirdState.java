package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class ThirdState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour()<17){
            System.out.println("当前时间" + work.getHour() + "点，下午状态还不错继续努力");
        }else {
            work.setState(new FourthState());
            work.writeProgram();
        }
    }
}
