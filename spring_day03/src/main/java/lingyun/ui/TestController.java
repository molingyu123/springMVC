package lingyun.ui;

import lingyun.dao.AccountDao;
import lingyun.dao.impl.AccountDaoImpl;
import lingyun.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestController {
    public static void main(String[] args) {
        // 演示上面的三个实现类的传参方式
        ClassPathXmlApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService =(AccountService) ac.getBean("accountService");
//        AccountService accountService2 =(AccountService) ac.getBean("accountService");
//        accountService.saveCount();
        accountService.saveCount();
        ac.close();
    }
}
