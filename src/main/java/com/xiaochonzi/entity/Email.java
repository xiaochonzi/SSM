package com.xiaochonzi.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by stone on 17/6/13.
 */
public class Email implements Serializable {

    private String address;
    private String cc;
    private String subject;
    private Map model;

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

    public Map getModel() {
        return model;
    }

    public void setModel(Map model) {
        this.model = model;
    }
}
