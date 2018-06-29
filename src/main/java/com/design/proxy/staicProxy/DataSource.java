package com.design.proxy.staicProxy;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.LinkedList;

/**
 * Created by Mcl on 2017/11/9.
 */
public class DataSource {
    private static LinkedList<Connection> connectionLinkedList = new LinkedList<Connection>();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private DataSource() {
        if (connectionLinkedList == null || connectionLinkedList.size() == 0) {
            for (int i = 0; i < 10; i++) {
                try {
                    connectionLinkedList.add(createNewConnection());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Connection createNewConnection() throws SQLException {
        return DriverManager.getConnection("url", "username", "password");
    }

    public static Connection getConnection() {
        if (connectionLinkedList.size() > 0) {
            return new ConnectionProxy(connectionLinkedList.remove());
        }
        return null;
    }

    public void recoveryConnection(Connection connection) {
        connectionLinkedList.add(connection);
    }

    private static class DataSourceInstance {
        private static DataSource dataSource = new DataSource();
    }

    public static DataSource getInstance() {
        return DataSourceInstance.dataSource;
    }
}
