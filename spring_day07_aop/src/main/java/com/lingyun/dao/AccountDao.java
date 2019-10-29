package com.lingyun.dao;

import com.lingyun.bean.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 查询单个
     * @param id
     * @return
     */
    Account findById(Integer id);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param id
     */
    void deleteAccount(Integer id);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的一个结果就返回，如果没有结果就返回null
     *          如果结果集超过一个就返回异常
     */
    Account findByName(String accountName);
}
