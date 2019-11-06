package lingyun.jdbcTemplate;

import lingyun.bean.Account;
import lingyun.dao.AccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * jdbcTemplate 模板的基本用法
 */
public class JdbcTemplateDemo04 {
    public static void main(String[] args) {
        //1.获取容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao",AccountDao.class);
        Account account=accountDao.findByAccountById(1);
        System.out.println(account);
        Account account1=accountDao.findByName("ccc");
        System.out.println(account1);
        account.setMoney(100f);
        accountDao.updateAccount(account);


    }
}
