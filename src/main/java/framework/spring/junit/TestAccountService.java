package framework.spring.junit;

/**
 * Created with IntelliJ IDEA.
 * User: gaozhan
 * Date: 4/29/14
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

//import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestAccountService {

//    Logger logger = Logger.getLogger("TestAccountService");

    AccountService service = null;
    ApplicationContext context = null;

    @Before
    public void init() {
        this.context = new ClassPathXmlApplicationContext("framework/spring/junit/applicationContext.xml");

        AccountService service = (AccountService) context.getBean("accountService");
        assertNotNull(service);
        this.service = service;

    }

    @Test
    public void testInsertAccount() {

        // 创建一个帐户
        Account account = (Account) context.getBean("accountEntity");
        // account.setAccountId(1);
        account.setUsername("selina");
        account.setPassword("123456");

        //将创建的帐户插入到数据库中
        service.insertAccount(account);
//        logger.debug("account id: " + account.getAccountId());

        //从数据库获取刚才插入的帐户
        Account accountFromDb = service.getAccountById(account);
        assertNotNull(accountFromDb);
        assertEquals(account.getAccountId(), accountFromDb.getAccountId());
    }

}