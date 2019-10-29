package com.lingyun.service;

import com.lingyun.bean.Account;

import java.sql.SQLException;
import java.util.List;


public interface AccountService {

    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws SQLException;

    /**
     * 查询单个
     * @param id
     * @return
     */
    Account findById(Integer id) throws SQLException;

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account) throws SQLException;

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account) throws SQLException;

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id) throws SQLException;

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名
     * @param money  金额
     */
    void transfer(String sourceName,String targetName,Float money) throws SQLException;
}
