package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class SecondState extends State {
    @Override
    public void writeProgram(Work work) {
        if(work.getHour()<13){
            System.out.println("当前时间" + work.getHour() + "点，饿了，午饭；犯困，午休");
        }else{
            work.setState(new ThirdState());
            work.writeProgram();
        }
    }
}
