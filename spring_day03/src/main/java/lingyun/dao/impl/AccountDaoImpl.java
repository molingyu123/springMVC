package lingyun.dao.impl;

import lingyun.dao.AccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao2")
public class AccountDaoImpl implements AccountDao {
    public void save() {
        System.out.println("保存到了数据库2222");
    }
}
