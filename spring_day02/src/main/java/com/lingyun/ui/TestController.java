package com.lingyun.ui;


import com.lingyun.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestController {
    public static void main(String[] args) {
//        IAccountService accountService = new IAccountServiceImpl();
        // 获取spring ioc 容器，并根据id 获取对象

        // 演示上面的三个实现类的传参方式
        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");  //比较常用
//        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\mly\\Desktop\\spring_day01\\src\\main\\resources\\bean.xml");
        //创建对象的两种方式的传参
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        accountService.IAccountService();
        System.out.println();


    }
}
