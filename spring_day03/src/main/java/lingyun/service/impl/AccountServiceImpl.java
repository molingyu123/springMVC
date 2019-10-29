package lingyun.service.impl;


import lingyun.dao.AccountDao;
import lingyun.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


/**
 * xml 配置 --下面的配置当中隐藏了几个属性如下
 * <bean id="accountService" class="lingyun.service.impl.IAccountServiceImpl"
 *   scope="" init-method="" destroy-method="">
 *   <property name="" value="" ref=""></property>
 * </bean>
 * 注解分为的四类对应xml 注解中属性和标签的功能对比，
 *用于创建对象
 *     他们的作用和xml 中使用bean 标签创建对象时相同的
 *    @Componment 用于把当前的对象存于spring 的容器中
 *      属性：value 用于指定bean 的id ,当我们不写时，就默认为当前类名且改首字母为小写
 *   @Controller 表现层
 *   @Service  业务层
 *  @Repository  持久层
 *  以上的三个注解他们的作用和属性与Componment 是一模一样
 *  它们三个是spring 框架为我们提供三层使用的注解，使我们对三层对象更加的清晰
 *
 * 用于注入数据
 *      @Autowired :
 *           作用：自动按照类型注入，只要容器中有唯一的一个bean 对象类型和要注入的变量类型匹配，就可以注入成功
 *                 如果ioc 容器中没有任何bean 的类型和要注入的变量匹配，则报错
 *                 如果ioc容器中出现了两个相同的bean 会更据类型,变量是否等于id 去匹配寻找，
 *                   匹配的原则：先根据class 确定类型，再根据变量名去匹配对应的id ,如果都相同spring
 *                   会报错提示出现了两个bean 对象
 *         出现位置：可以用在变量上，也可以用在方法上
 *         细节：在使用注解注入的时候set方法就不是必须的了
 *     @Qualifier --不能单独使用
 *          作用：在按照类中注入的基础之上再按照名称注入，它再给类成员注入时不能单独使用，但是再给方法参数注入时可以
 *          属性：
 *              value ：用于指定注入bean 的id
 *     @Resource
 *          作用：直接按照bean 的id 注入，它可以独立使用
 *          属性：
 *             name :用于指定bean 的id
 *      以上三个注入只能注入其它bean 类型的数据，而基本类型和String 类型无法使用上述注解实现
 *      另外,集合类型的注入只能通过xml 实现
 *    @Value ：
 *       作用：用于注入基本类型合string 类型的数据
 *       属性：
 *          value: 用于指定数据的值,它可以使用spring中的el表达式
 *                  SpEL的写法：${表达式}
 *     这个就对应bean 标签中写入的property 标签是相同
 *用于改变作用范围
 *     对应xml 中使用scope
 *      @Scope :
 *        作用：用于指定bean 的作用范围
 *        属性：
 *           value:指定范围的取值，常用取值，singleton,prototype
 *和生命周期有关的(了解）
 *    @PreDestroy
 *        作用：用于指定销毁的方法
 *    @PostConstruct
 *       作用：用于指定初始化方法
 *    对应 xml 中使用的初始化方法和销毁的方法
 */
@Repository(value="accountService")
public class AccountServiceImpl implements AccountService {



    @Resource(name = "accountDao1")
   private AccountDao accountDao;

   public AccountServiceImpl(){
       System.out.println("初始化：");
   }

   @PostConstruct
   public void int02(){
       System.out.println("初始化方法执行了");
   }

   @PreDestroy
   public void destroy(){
       System.out.println("销毁方法执行了");
   }
    public   void saveCount(){
        accountDao.save();
    }





}
