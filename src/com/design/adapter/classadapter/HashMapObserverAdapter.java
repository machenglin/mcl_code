package com.design.adapter.classadapter;

import com.design.observer.Observable;
import com.design.observer.Observer;

import java.util.HashMap;

/**
 * 适配器设计模式：类适配器，采用继承
 * 需求：将HashMapObserverAdapter加入观察者列表中，在被观察者发生变化时，我们要清空整个Map
 * 问题：HashMap本身没有实现Observer接口，且我们不能对HashMap进行修改。
 * Created by Mcl on 2017/11/10.
 */
public class HashMapObserverAdapter<K, V> extends HashMap<K, V> implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        super.clear();
    }
}
