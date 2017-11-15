package com.design.adapter.objectadapter;

import com.design.observer.Observable;
import com.design.observer.Observer;

/**
 * 对象适配器：采用组合
 * 需求：我们需要把User作为被观察者
 * 问题：我们需要被观察者继承Observable类，但是User已经有了父类BaseEntity。
 *
 * Created by Mcl on 2017/11/14.
 */
public class ObserverUser extends User{
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

class User extends BaseEntity {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

