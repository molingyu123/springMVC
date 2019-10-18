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
//        IAccountService accountService1 =(IAccountService) ac.getBean("accountService");
        accountService.IAccountService();
        System.out.println();
        //main 方法是一切应用程序入口，程序运行完结束了对象就消失了，那么这里需要手动的去调用销毁的方法

        // 打印结果为true 表明spring 对象默认创建的对象是单列
        // 当改为scope ="prototype" 结果为false 表明是个多列的对象

        ((ClassPathXmlApplicationContext) ac).close();

        // 上面是单列的演示现在改为多列




    }
}
