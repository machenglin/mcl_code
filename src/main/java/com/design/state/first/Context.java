package com.design.state.first;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by machenglin on 2018/5/17.
 */
@Getter
@Setter
public class Context {
    private State state;
    public void request() {
        state.handle(this);
    }
}
