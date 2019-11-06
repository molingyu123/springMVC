package lingyun.dao;

import lingyun.bean.Account;

/**
 * 账户持久层接口
 */
public interface AccountDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Account findByAccountById(Integer id);

    /**
     * 根据名称
     * @param name
     * @return
     */
    Account findByName(String name);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);
}
