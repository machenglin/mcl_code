package com.design.state.second;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by machenglin on 2018/5/17.
 */
@Getter
@Setter
public class Work {
    private State state;
    private double hour;
    private boolean finish = false;

    public Work() {
        state = new FirstState();
    }

    public void writeProgram() {
        state.writeProgram(this);
    }


}
