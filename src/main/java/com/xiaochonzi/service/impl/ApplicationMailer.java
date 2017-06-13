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
    public void sendMailSychronized(Email email) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setTo(InternetAddress.parse(email.getAddress()));
            helper.setText(email.getContent());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
