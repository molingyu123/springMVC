package com.lingyun.dao.impl;

import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class AccountDaoImpl implements AccountDao {


    private QueryRunner runner;

    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    //    public QueryRunner getRunner() {
//        return runner;
//    }

    public void setRunner(QueryRunner runner) {

        this.runner = runner;
    }

    public List<Account> findAllAccount() {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Account findById(Integer id) {
        try{
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id=?",new BeanHandler<Account>(Account.class),id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void saveAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) value(?,?)",account.getName(),account.getMoney());
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public void deleteAccount(Integer id) {
        try{
            runner.update(connectionUtils.getThreadConnection(),"delete from account  where id=?",id);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    public Account findByName(String accountName) {
        try{
            List<Account> accounts = runner.query(connectionUtils.getThreadConnection(),
                    "select * from account where name=?",
                    new BeanListHandler<Account>(Account.class),accountName);
            if(accounts ==null || accounts.size()==0){
                return  null;
            }else if(accounts.size()>1){
                throw  new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException();
        }

    }
}
