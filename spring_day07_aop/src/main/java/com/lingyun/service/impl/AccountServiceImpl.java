package com.lingyun.service.impl;

import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.dao.impl.AccountDaoImpl;
import com.lingyun.service.AccountService;
import com.lingyun.utils.TransactionManager;

import java.sql.SQLException;
import java.util.List;

/**
 * 事务都是在业务层控制
 */
public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<Account> findAllAccount() {
            List<Account> accounts=accountDao.findAllAccount();
            return  accounts;
    }

    public Account findById(Integer id){
        Account account=accountDao.findById(id);
        return  account;
    }

    public void saveAccount(Account account){
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id)  {
        accountDao.deleteAccount(id);
    }

    public void transfer(String sourceName, String targetName, Float money) {
        Account account = accountDao.findByName(sourceName);
        // 根据名称查询转入账户
        Account account1 = accountDao.findByName(targetName);
        // 转出账户减钱
        account.setMoney(account.getMoney()-money);
        // 转入账户加钱
        account1.setMoney(account1.getMoney()+money);
        // 更新转出账户
        accountDao.updateAccount(account);
        // 更新转入账户
        accountDao.updateAccount(account1);
    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
