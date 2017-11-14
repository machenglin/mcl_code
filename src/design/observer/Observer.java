package design.observer;

import java.util.*;

/**
 * 观察者接口
 * Created by Mcl on 2017/11/13.
 */
public interface Observer {

    void update(Observable o, Object arg);
}
