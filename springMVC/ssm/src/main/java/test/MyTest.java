package test;


import com.lingyun.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MyTest {

    @Test
    public void test1(){
        // 加载配置文件的方法
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountService accountService =(AccountService) applicationContext.getBean("accountService");
        accountService.findAll();
    }
}
