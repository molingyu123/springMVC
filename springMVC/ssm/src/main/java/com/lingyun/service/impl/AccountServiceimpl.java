package com.lingyun.service.impl;

import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceimpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("service 层查询所有...");
        List<Account> accountList = accountDao.findAll();
        return accountList;
    }

    @Override
    public void save(Account account) {
        accountDao.save(account);
    }
}
