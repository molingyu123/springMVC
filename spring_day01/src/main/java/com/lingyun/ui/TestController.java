package com.lingyun.ui;

import com.lingyun.dao.IAccountDao;
import com.lingyun.service.IAccountService;
import com.lingyun.service.impl.IAccountServiceImpl;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestController {
    public static void main(String[] args) {
//        IAccountService accountService = new IAccountServiceImpl();
        // 获取spring ioc 容器，并根据id 获取对象
        /**
         * applicationContext 常用三个实现类
         *    ClassPathXmlApplication 它可以加载类路径下的配置文件要求配置文件必须再类路径下
         *    FileSystemXmlApplication  它可以加载磁盘任意路径下的配置文件（必须有访问权限)
         *    AnnotationConfigApplication  它是用于读取注解创建容器的
         *
         *   核心容器接口引发的问题
         *   ApplicationContext : 适用于单列场景
         *      它再构建核心容器时创建对象采取的策略是采用立即加载的方式，也就是说，只要一读取配置文件就创建
         *      配置文件中的配置对象
         *   BeanFactory：多列对象场景使用
         *     它在构建核心容器时，创建对象采取的策略时采用延迟加载的方式，也就是说，什么时候根据id 获取对象了
         *     什么时候才真正的创建对象
         *   区别：这两个对象创建对象的时机不一样，场景使用不同
         */
        // 演示上面的三个实现类的传参方式
//        ApplicationContext ac =new ClassPathXmlApplicationContext("bean.xml");  //比较常用
////        ApplicationContext ac = new FileSystemXmlApplicationContext("C:\\Users\\mly\\Desktop\\spring_day01\\src\\main\\resources\\bean.xml");
//        //创建对象的两种方式的传参
//        IAccountService accountService = (IAccountService) ac.getBean("accountService");
//        IAccountDao accountDao =ac.getBean("accountDao",IAccountDao.class);
//        System.out.println(accountService);
//        System.out.println(accountDao);
        /**
         * 结果：
         * com.lingyun.service.impl.IAccountServiceImpl@279ad2e3
         * com.lingyun.dao.impl.IAccountDaoImpl@58134517
         */

        //---演示BeanFactory
        Resource resource=new ClassPathResource("bean.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService accountService = (IAccountService) factory.getBean("accountService");
        System.out.println(accountService);
    }
}
