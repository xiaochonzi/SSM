package com.xiaochonzi.service.impl;

import com.xiaochonzi.entity.Email;
import com.xiaochonzi.entity.User;
import com.xiaochonzi.service.MailService;
import com.xiaochonzi.util.Constants;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
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
    @Qualifier("velocityEngine")
    private VelocityEngine velocityEngine;

    /**
     * 异步邮件发送
     * @param email
     * @throws MessagingException
     */

    public void sendMail(Email email){
        try{
            sendMailSychronized(email);
        }catch (MessagingException e){
            e.printStackTrace();
        }
    }

    /**
     * 同步邮件发送
     * @param email
     */
    public void sendMailSychronized(Email email) throws MessagingException {
        Session session = Session.getDefaultInstance(new Properties());
        MimeMessage message = new MimeMessage(session);
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(new InternetAddress(Constants.ADMIN_EMAIL));
        helper.setTo(email.getAddress());
        helper.setSubject(email.getSubject());
        String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "email/email-register.vm", "UTF-8", email.getModel());
        helper.setText(text, true);
        mailSender.send(message);
    }

}
