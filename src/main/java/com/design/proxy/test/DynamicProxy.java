package com.design.proxy.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Mcl on 2018/5/16.
 */
public class DynamicProxy implements InvocationHandler {
    private Object source;

    public DynamicProxy(Object object) {
        this.source = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //return method.invoke(source, args);
        System.out.println("接口的方法全部变成这样了");
        return null;
    }

    public static void main(String[] args) {
        TestInterface obj = (TestInterface)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{TestInterface.class},
                new DynamicProxy(new TestClass()));
        obj.method1();
        obj.method2();
        obj.method3();

    }
}
