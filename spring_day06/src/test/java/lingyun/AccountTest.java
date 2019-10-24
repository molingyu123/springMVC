package lingyun;

import com.lingyun.bean.Account;
import com.lingyun.service.AccountService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * 测试
 * spring 整合junit 测试
 *   1.导入spring 整合junit 的jar包(坐标)
 *   2.使用junit 提供的一个注解，把原有的main方法替换成spring 提供的
 *    @Runnwith
 *   3.告诉spring的运行器spring 和ioc 创建时基于xml 还是注解的并且说明位置
 *    @ContextConfiguration
 *      locations:只当xml文件位置，加上classpath 关键字，表示再类路径下
 *      classes:指定注解类所在地位置--表明是使用注解配置
 * 当我们使用spring5.x版本的时候junit jar 必须是4.12及以上
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testFindAll() {
        List<Account> accounts=accountService.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
    @Test
    public void testFindById() {
        Account account=accountService.findById(1);
        System.out.println(account);
    }
    @Test
    public void testFindSave() {
        Account account = new Account();
        account.setName("小米");
        account.setMoney(new Float(100000));
        accountService.saveAccount(account);
        Account account1=accountService.findById(4);
        System.out.println(account1);
    }
    @Test
    public void testFindUpdate() {
        Account account =new Account();
        account.setMoney(new Float(8888));
        account.setName("华为");
        account.setId(1);
        accountService.updateAccount(account);
        Account account1=accountService.findById(1);
        System.out.println(account1);
    }
    @Test
    public void testFindDelete() {
        accountService.deleteAccount(2);
        List<Account> accounts=accountService.findAllAccount();
        for(Account account:accounts){
            System.out.println(account);
        }
    }
}
