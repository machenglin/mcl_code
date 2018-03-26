package com.design.observer;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 观察者类：读者类
 * Created by Mcl on 2017/11/13.
 */
@Getter
@Setter
@AllArgsConstructor
public class Reader implements Observer {
    private String name;

    /**
     * 关注一个作者
     */

    public void subscribe(String name) {
        Writer writer = WriterManager.getInstance().getWriterByName(name);
        if (writer != null) {
            writer.addObserver(this);
        }
    }

    /**
     * 取消关注一个作者
     */

    public void unSubscribe(String name) {
        Writer writer = WriterManager.getInstance().getWriterByName(name);
        if (writer != null) {
            writer.deleteObserver(this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Writer) {
            Writer writer = (Writer) o;
            System.out.println(name+"知道" + writer.getName() + "发布了新书《" + writer.getLastNovel() + "》，非要去看！");
        }
    }
}
