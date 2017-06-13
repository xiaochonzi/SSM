package com.xiaochonzi.service;

import com.xiaochonzi.entity.ApplicationEmail;

import javax.mail.MessagingException;

/**
 * Created by stone on 17/6/13.
 */
public interface Mailer {
    void sendMailAsynchronizedmode(ApplicationEmail email) throws MessagingException;
}
