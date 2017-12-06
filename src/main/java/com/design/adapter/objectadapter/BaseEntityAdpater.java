package com.design.adapter.objectadapter;

import com.design.observer.Observable;
import com.design.observer.Observer;

/**
 * 对象适配器：采用组合
 * 如果还有People, User，Employee需要被观察者的功能，那么只需要将他们由继承BaseEntity,转为继承BaseEntityAdapter。
 * 这样没有影响原来的继承体系
 * Created by Mcl on 2017/11/14.
 */
public class BaseEntityAdpater extends BaseEntity {
    private Observable observable;

    public synchronized void addObserver(Observer o) {
        observable.addObserver(o);
    }

    public synchronized void deleteObserver(Observer o) {
        observable.deleteObserver(o);
    }

    public void notifyObservers() {
        observable.notifyObservers();
    }

    public void notifyObservers(Object arg) {
        observable.notifyObservers(arg);
    }

    public synchronized void deleteObservers() {
        observable.deleteObservers();
    }

    protected synchronized void setChanged() {
        observable.setChanged();
    }

    protected synchronized void clearChanged() {
        observable.clearChanged();
    }

    public synchronized boolean hasChanged() {
        return observable.hasChanged();
    }

    public synchronized int countObservers() {
        return observable.countObservers();
    }
}
