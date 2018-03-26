package com.design.decorator;

import lombok.AllArgsConstructor;

/**
 * Created by Mcl on 2018/3/15.
 */
@AllArgsConstructor
public class Decorator implements Component {
    protected Component component;

    @Override
    public void method() {
        component.method();
    }
}
