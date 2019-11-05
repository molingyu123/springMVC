package com.lingyun;


import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存");
//        int i=1/0;演示异常通知
    }

    public void updateAccount(int i) {
        System.out.println("执行了保存");
    }

    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
