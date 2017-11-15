package com.design.observer;

/**
 * Created by Mcl on 2017/11/13.
 */
public class Writer extends Observable {

    private String name;
    private String lastNovel;

    /**
     *作者发布新小说了，要通知所有关注自己的读者
     */
    public void addNovel(String novel) {
        System.out.println(name + "发布了新书《" + novel + "》！");
        lastNovel = novel;
        setChanged();
        notifyObservers();
    }

    public Writer(String name) {
        super();
        this.name = name;
        WriterManager.getInstance().add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNovel() {
        return lastNovel;
    }

    public void setLastNovel(String lastNovel) {
        this.lastNovel = lastNovel;
    }
}
