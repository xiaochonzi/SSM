package com.xiaochonzi.service.impl;

import com.xiaochonzi.entity.Email;
import com.xiaochonzi.service.MailService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by stone on 17/6/13.
 */
public class ApplicationMailerTest {

    private ApplicationContext context;
    private MailService mailService;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        mailService = context.getBean("mailer",MailService.class);
    }

    @Test
    public void sendMail() throws Exception {
        Email email = new Email();
        email.setSubject("测试");
        email.setAddress("326688269@qq.com");
        email.setContent("你好");
        mailService.sendMail(email);
    }

}