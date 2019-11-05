package test;

import com.lingyun.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试aop 的配置
 */
public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService =(AccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
    }
}
