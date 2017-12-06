package com.design.proxy.dynamic;

import com.design.proxy.staicProxy.DataSource;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * 动态代理实现连接池的代理
 * Created by Mcl on 2017/11/9.
 */
public class ConnectionProxy implements InvocationHandler {
    private Connection connection;

    public ConnectionProxy(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Connection.class.isAssignableFrom(proxy.getClass()) && method.getName().equals("close")) {
            DataSource.getInstance().recoveryConnection(connection);
            return null;
        }
        return method.invoke(connection, args);
    }

    public Connection getConnectionProxy() {
        return (Connection) Proxy.newProxyInstance(getClass().getClassLoader(), new Class[]{Connection.class}, this);
    }
}
