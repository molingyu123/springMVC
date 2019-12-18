package com.lingyun.service;

import com.lingyun.bean.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void save(Account account);
}
