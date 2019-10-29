package com.lingyun.service.impl;

import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.dao.impl.AccountDaoImpl;
import com.lingyun.service.AccountService;
import com.lingyun.utils.TransactionManager;

import java.util.List;

/**
 * 事务都是在业务层控制
 */
public class AccountServiceImpl_old implements AccountService {


    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public List<Account> findAllAccount() {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
            return  accounts;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.close();
        }
    }

    public Account findById(Integer id){
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account=accountDao.findById(id);
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
            return  account;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.close();
        }
    }

    public void saveAccount(Account account){
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.close();
        }
    }

    public void updateAccount(Account account) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.close();
        }
    }

    public void deleteAccount(Integer id)  {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
//            return  account;
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //6.释放资源
            transactionManager.close();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            // 根据名称查询转出账户
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
            //3.提交事务
            transactionManager.commitTransaction();
            //4.返回结果
        }catch (Exception e){
            //5.回滚操作
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //6.释放资源
            transactionManager.close();
        }

    }

    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao = accountDao;
    }
}
