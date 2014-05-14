package com.juvenxu.mvnbook.account.email;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.mail.Message;

import static junit.framework.Assert.assertEquals;

public class AccountEmailServiceOnlyTest
{
    private GreenMail greenMail;



    @Test
    public void testSendMail()
        throws Exception
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext( "account-email.xml" );
        AccountEmailService accountEmailService = (AccountEmailService) ctx.getBean( "accountEmailService" );

        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail( "tempmiddle@163.com", subject, htmlText );


//        System.out.println(msgs[0].getFrom()[0]);
    }
}
