package com.design.proxy.dynamic;

import lombok.AllArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Mcl on 2017/11/9.
 */
public class DynamicProxy implements InvocationHandler {
    private Object source;

    public DynamicProxy(Object source) {
        super();
        this.source = source;
    }

    public void before() {
        System.out.println("在方法前做一些事，比如打开事务");
    }

    public void after() {
        System.out.println("在方法返回前做一些事，比如提交事务");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //假设我们切入toString方法，其他其实也是类似的，一般我们这里大部分是针对特定的方法做事情的，通常不会对类的全部方法切入
        //比如我们常用的事务管理器，我们通常配置的就是对save,update,delete等方法才打开事务
        if (method.getName().equals("print")) {
            before();
        }
        Object result = method.invoke(source, args);
        if (method.getName().equals("print")) {
            after();
        }
        return result;
    }

    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), source.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) throws Throwable {
        DynamicProxy dynamicProxy = new DynamicProxy(new User("小明"));

        UserInterface user = (UserInterface) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                User.class.getInterfaces(), dynamicProxy);
        user.print();

    }

    public interface UserInterface{
        void print();
    }
    @AllArgsConstructor
    public static class User implements UserInterface{
        private String name;

        @Override
        public void print() {
            System.out.println(this.toString());
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }

    }
}
