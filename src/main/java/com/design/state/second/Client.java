package com.design.state.second;

/**
 * Created by machenglin on 2018/5/17.
 */
public class Client {
    public static void main(String[] args) {
        Work work = new Work();
        work.setHour(9);
        work.writeProgram();
        work.setHour(10);
        work.writeProgram();
        work.setHour(12);
        work.writeProgram();
        work.setHour(13);
        work.writeProgram();
        work.setHour(14);
        work.writeProgram();
        work.setHour(17);
        work.writeProgram();
        work.setFinish(true);
        work.setHour(19);
        work.writeProgram();
        work.setHour(22);
        work.writeProgram();
    }
}
