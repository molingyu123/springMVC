package com.lingyun.utils;

import java.sql.SQLException;

/**
 * 事务管理的相关的工具类包含了：
 *    开启事务，提交事务，回滚事务和释放连接
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;
    public void setConnectionUtils(ConnectionUtils connectionUtils) {

        this.connectionUtils = connectionUtils;
    }
    /**
     * 开启事务
     */
    public void beginTransaction(){
        try{
            connectionUtils.getThreadConnection().setAutoCommit(false);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commitTransaction()  {
        try{
            connectionUtils.getThreadConnection().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 回滚事务
     */
    public void rollback(){
        try{
            connectionUtils.getThreadConnection().rollback();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 释放连接
     */
    public void close(){
        try{
            connectionUtils.getThreadConnection().close();
            connectionUtils.removeConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
