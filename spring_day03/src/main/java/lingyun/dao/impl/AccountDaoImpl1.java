package lingyun.dao.impl;

import lingyun.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao1")
public class AccountDaoImpl1 implements AccountDao {
    public void save() {
        System.out.println("保存到了数据库aaa");
    }
}
