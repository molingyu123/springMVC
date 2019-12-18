package com.lingyun.dao;

import com.lingyun.bean.Account;

import java.util.List;

public interface AccountDao {

    List<Account> findAll();

    void save(Account account);
}
