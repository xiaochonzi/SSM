package com.xiaochonzi.util;


import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

/**
 * Created by stone on 17/6/11.
 */
public class Constants {

    public static final String ADMIN_EMAIL = "swtxcz1993@163.com";

    public static String md5Hex(String src){
        try{
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bs = md5.digest(src.getBytes());
            return new String(new Hex().encode(bs));
        }catch (Exception e){
            return null;
        }
    }
}
