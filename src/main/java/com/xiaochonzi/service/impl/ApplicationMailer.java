package com.xiaochonzi.service.impl;

import com.xiaochonzi.entity.Email;
import com.xiaochonzi.service.MailService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by stone on 17/6/13.
 */
@Service("mailer")
public class ApplicationMailer implements MailService {

    @Autowired
    @Qualifier("mailSender")
    private JavaMailSender mailSender;

    @Autowired
    @Qualifier("taskExecutor")
    private TaskExecutor taskExecutor;

    /**
     * 异步邮件发送
     * @param email
     * @throws MessagingException
     */
    public void sendMail(final Email email) throws MessagingException {
        taskExecutor.execute(new Runnable() {
            public void run() {
                sendMailSychronized(email);
            }
        });
    }

    /**
     * 同步邮件发送
     * @param email
     */
    public void sendMailSychronized(final Email email) {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(new InternetAddress("stone931027@gmail.com", "知识林", "UTF-8"));
            helper.setTo("326688269@qq.com");
            helper.setSubject("标题：发送Html内容");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        mailSender.send(message);
    }

}
