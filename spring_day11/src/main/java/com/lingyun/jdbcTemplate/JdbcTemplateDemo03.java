package com.lingyun.jdbcTemplate;

import com.lingyun.bean.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * jdbcTemplate 模板的基本用法
 * crud
 */
public class JdbcTemplateDemo03 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean("jdbcTemplate",JdbcTemplate.class);
        // 插入
//        jdbcTemplate.execute("insert into account (name,money) value ('ddd',10000)");
        // 保存
//         jdbcTemplate.update("insert into account (name, money) value (?,?)","eee",222f);
        //更新
//         jdbcTemplate.update("update account set name=? ,money=? where id=?","ccc",123,10);
        //删除
//        jdbcTemplate.update("delete from account where id=?",10);
        //查询所有
//        List<Account> accountList=jdbcTemplate.query("select * from account where money>?",new AccountRowMapper(),100f);
        // 采用spring 提供的方法
//        List<Account> accountList= jdbcTemplate.query("select * from account where money>?",new BeanPropertyRowMapper<Account>(Account.class),1000f);
//        for(Account a:accountList){
//            System.out.println(a);
//        }
        //查询一个
//        List<Account> accountList2= jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),9);
//        System.out.println(accountList2.isEmpty()?"没有内容":accountList2.get(0));

        //查询返回一行一列(聚合函数，但不加group by 字句)
        Integer account =jdbcTemplate.queryForObject("select count(1) from account where money>?",Integer.class,1000f);
        System.out.println(account);


    }
}

class AccountRowMapper implements RowMapper<Account>{

    /**
     * 把结果集的数据封装中account 中，然后由spring 把每个account 加到集合中
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setMoney(resultSet.getFloat("money"));
        account.setName(resultSet.getString("name"));
        return account;
    }
}
