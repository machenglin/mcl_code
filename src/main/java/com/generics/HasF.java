package com.generics;

/**
 * Created by machenglin on 2018/4/11.
 */
public class HasF {
    public void fun(){
        System.out.println("HasF.fun()");
    }
}

/**
 * 声明T必须具有类型Hasf或者从HasF导出的类型。
 * @param <T>
 */
class Manipulator<T extends HasF>{
    private T obj;

    public Manipulator(T obj) {
        this.obj = obj;
    }
    public void mannipulate(){
        obj.fun();
    }

}
