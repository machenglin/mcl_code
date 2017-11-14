package design.adapter.defaultadapter;

/**
 * 缺省适配器:
 * 由于有的接口并没有做到最小接口原则，而有的类确不得不实现该接口时的默认实现
 * Created by Mcl on 2017/11/14.
 */
public class DefaultPerson implements Person{
    @Override
    public void speak() {

    }

    @Override
    public void listen() {

    }

    @Override
    public void work() {

    }
}
