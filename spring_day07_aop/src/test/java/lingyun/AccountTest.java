package lingyun;

import com.lingyun.bean.Account;
import com.lingyun.service.AccountService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() throws SQLException {
        accountService.transfer("华为","cc",new Float(80));
    }

}
