package lingyun.dao.impl;

import lingyun.bean.Account;
import lingyun.dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Account findByAccountById(Integer id) {
       List<Account> accounts= jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),id);
       return accounts.isEmpty()?null:accounts.get(0);
    }

    public Account findByName(String name) {
        List<Account> accounts= jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),name);
        if(accounts.isEmpty()){
            return  null;
        }
        if(accounts.size()>1){
            throw new RuntimeException("结果集不唯一");
        }
        return accounts.get(0);
    }

    public void updateAccount(Account account) {
       jdbcTemplate.update("update account set name=? ,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
