package com.design.state.first;

/**
 * Created by machenglin on 2018/5/17.
 */
public class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        context.setState(new ConcreteStateA());
    }
}
