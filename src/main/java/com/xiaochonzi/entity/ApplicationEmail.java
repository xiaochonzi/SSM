package com.xiaochonzi.entity;

import java.io.Serializable;

/**
 * Created by stone on 17/6/13.
 */
public class ApplicationEmail implements Serializable {

    private String address;
    private String cc;
    private String subject;
    private String content;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
