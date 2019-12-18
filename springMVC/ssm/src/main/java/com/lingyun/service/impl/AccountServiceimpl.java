package com.lingyun.service.impl;

import com.lingyun.bean.Account;
import com.lingyun.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("accountService")
public class AccountServiceimpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("service 层查询所有...");
        return null;
    }

    @Override
    public void save(Account account) {
        System.out.println("service 层保存");
    }
}
