package test;


import com.lingyun.bean.Account;
import com.lingyun.dao.AccountDao;
import com.lingyun.service.AccountService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;


public class MyTest {

    @Test
    public void test1(){
        // 加载配置文件的方法
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService =(AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
    }

    // 测试mybatis
    @Test
    public void test2 () throws Exception{
      InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
      // 创建sqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建对象
        SqlSession sqlSession = build.openSession();
        // 获取代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        // 查询所有的账户信息
        List<Account> all = mapper.findAll();
        for(Account account:all){
            System.out.println(account);
        }
        // 关闭流
        sqlSession.close();
        inputStream.close();
    }

    @Test
    public void test3() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 创建sqlSessionFactory
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(inputStream);
        // 创建对象
        SqlSession sqlSession = build.openSession();
        // 获取代理对象
        AccountDao mapper = sqlSession.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("aaaddd");
        account.setMoney(440d);
        mapper.save(account);
        sqlSession.commit();// 提交事务
        // 关闭流
        sqlSession.close();
        inputStream.close();
    }
}
