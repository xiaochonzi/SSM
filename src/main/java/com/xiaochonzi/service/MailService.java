package com.xiaochonzi.service;

import com.xiaochonzi.entity.Email;

import javax.mail.MessagingException;

/**
 * Created by stone on 17/6/13.
 */
public interface MailService {

    void sendMail(Email email) throws MessagingException;
}
