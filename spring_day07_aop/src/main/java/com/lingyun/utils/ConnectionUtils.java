package com.lingyun.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接工具类,它用于从数据源中获取一个连接，并且实现和线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal=new ThreadLocal<Connection>();
    private DataSource dataSource;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    /**
     * 获取当前线程的连接
     * @return
     */
    public Connection getThreadConnection() {
        try{
            // 1.先从threadLocal 获取
            Connection connection = threadLocal.get();
            if(connection==null){
                // 从数据源上获取一个连接，并且存入threadLocal 中
                connection = dataSource.getConnection();
                threadLocal.set(connection);
            }
            //返回当前线程上的连接
            return connection;
        }catch (Exception e){
            throw  new RuntimeException();
        }

    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection(){
        threadLocal.remove();
    }
}
