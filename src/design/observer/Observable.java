package design.observer;

import java.util.Vector;

/**
 * 背被观察者类：作者类
 * Created by Mcl on 2017/11/13.
 */
public class Observable {

    /**
     * 标记被观察者有没有改变
     */
    private boolean changed = false;

    /**
     * 持有一个观察者列表
     */
    private Vector<Observer> obs;

    public Observable() {
        obs = new Vector<Observer>();
    }

    /**
     * 添加观察者
     */

    public synchronized void addObserver(Observer observer) {
        if (observer == null) {
            throw new NumberFormatException();
        }
        if (!obs.contains(observer)) {
            obs.addElement(observer);
        }
    }

    /**
     * 删除观察者
     */
    public synchronized void deleteObserver(Observer observer) {
        obs.remove(observer);
    }

    /**
     * 删除所有观察者
     */
    public synchronized void deleteObservers() {
        obs.removeAllElements();
    }

    /**
     * notifyObservers(Object arg)的重载方法
     */
    public void notifyObservers() {
        notifyObservers(null);
    }

    /**
     * 通知所有观察者，被观察者改变了，你可以执行你的update方法了
     *
     * @param arg
     */
    public void notifyObservers(Object arg) {
        // 一个临时数组，用于并发访问被观察者时，留住观察者列表的当前状态，【备忘录模式】
        Object[] arrLocal;
        synchronized (this) {
            // 如果没有变化直接返回
            if (!changed) {
                return;
            }
            arrLocal = obs.toArray();
            clearChanged();
            for (int i = arrLocal.length - 1; i >= 0; i--) {
                ((Observer) arrLocal[i]).update(this, arg);
            }
        }
    }

    /**
     * 标识被观察者没有被改变
     */
    public synchronized void clearChanged() {
        changed = false;
    }

    /**
     * 标识被观察者被改变
     */
    public synchronized void setChanged() {
        changed = true;
    }

    /**
     * @return 返回观察者是否改变
     */
    public synchronized boolean hasChanged() {
        return changed;
    }

    /**
     * @return  返回观察者的数量
     */
    public synchronized int countObservers() {
        return obs.size();
    }


}
