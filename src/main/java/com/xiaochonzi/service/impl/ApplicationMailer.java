package com.xiaochonzi.service.impl;

import com.xiaochonzi.entity.ApplicationEmail;
import com.xiaochonzi.service.Mailer;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by stone on 17/6/13.
 */
public class ApplicationMailer implements Mailer {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TaskExecutor taskExecutor;

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    public void sendMailAsynchronizedmode(final ApplicationEmail email) throws MessagingException {
        taskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    Session session = Session.getDefaultInstance(new Properties());
                    MimeMessage mime = new MimeMessage(session);
                    MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");
                    helper.setFrom("swtxcz1993@163.com");
                    helper.setTo(InternetAddress.parse(email.getAddress()));
                    helper.setSubject(email.getSubject());
                    helper.setText(email.getContent(), true);
                    mailSender.send(mime);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
