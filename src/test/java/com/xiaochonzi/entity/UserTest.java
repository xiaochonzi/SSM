package com.xiaochonzi.entity;

import com.xiaochonzi.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by stone on 17/6/18.
 */
public class UserTest {

    private ApplicationContext context;
    private UserService userService;
    @Before
    public void setUp() throws Exception {
        context = new ClassPathXmlApplicationContext("spring-context.xml");
        userService = context.getBean("userService",UserService.class);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void generateConfirmToken() throws Exception {
        User user = new User();
        user.setEmail("326688269@qq.com");
        user.setUserName("xiaochonzi");
        user.setPasswordHash("qazwsx1010");
        user.setComfirmed(false);
        userService.register(user);
        String token = user.generateConfirmToken();
        System.out.println(token);
        user.confirm(token);
    }

    @Test
    public void confirm() throws Exception {

    }

}