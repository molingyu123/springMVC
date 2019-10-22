package com.lingyun.service.impl;

import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.dao.impl.AccountDaoImpl;
import com.lingyun.service.AccountService;


import java.util.List;

public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    public void saveAccount(Account account) {
      accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
      accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);

    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
