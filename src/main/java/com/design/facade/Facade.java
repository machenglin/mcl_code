package com.design.facade;

import lombok.AllArgsConstructor;

/**
 * 外观类：
 * Created by machenglin on 2018/5/17.
 */
@AllArgsConstructor
public class Facade {
    SubSystemOne subSystemOne;
    SubSystemTwo subSystemTwo;
    SubSystemThree subSystemThree;
    public void methodA(){
        subSystemOne.methodOne();
        subSystemTwo.methodTwo();
    }

    public void methodB(){
        subSystemTwo.methodTwo();
        subSystemThree.methodThree();
    }
}
