package lingyun;

import com.lingyun.bean.Account;
import com.lingyun.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 测试
 */
public class AccountTest {
    private ApplicationContext ac;
    private AccountService accountService;
    @Before
    public void before(){
        ac = new ClassPathXmlApplicationContext("bean.xml");
        accountService = ac.getBean("accountService",AccountService.class);
    }
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
    @After
    public void closeInit(){
        ((ClassPathXmlApplicationContext) ac).close();
    }
}
