package com.xiaochonzi.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xiaochonzi.util.Constants;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.util.*;

/**
 * Created by stone on 17/6/8.
 */
public class User {
    private Integer id;
    private String email;
    private String userName;
    private String passwordHash;
    private Boolean comfirmed;
    private Date memberSince;
    private Date lastSeen;
    private String avatarHash;
    private Role role;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Boolean getComfirmed() {
        return comfirmed;
    }

    public void setComfirmed(Boolean comfirmed) {
        this.comfirmed = comfirmed;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public Date getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(Date lastSeen) {
        this.lastSeen = lastSeen;
    }

    public String getAvatarHash() {
        return avatarHash;
    }

    public void setAvatarHash(String avatarHash) {
        this.avatarHash = avatarHash;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void gernatePassword(String password){
        Random r = new Random();
        StringBuffer buffer = new StringBuffer();
        buffer.append(r.nextInt(9999)).append(r.nextInt(9999));
        int len = buffer.length();
        if(len < 16){
            for(int i=0;i<16-len;i++){
                buffer.append("0");
            }
        }
        String salt = buffer.toString();
        String passwordMd5 = Constants.md5Hex(password+salt);
        char []cs = new char[48];
        for(int i=0;i<48;i+=3){
            cs[i]= passwordMd5.charAt(i/3*2);
            char c = salt.charAt(i/3);
            cs[i+1] = c;
            cs[i+2] = passwordMd5.charAt(i/3*2+1);
        }
        this.passwordHash = new String(cs);
    }

    public boolean verifyPassword(String password){
        char[] cs1 = new char[32];
        char[] cs2 = new char[16];
        for(int i=0;i<48;i+=3){
            cs1[i/3*2] = this.passwordHash.charAt(i);
            cs1[i/3*2+1]= this.passwordHash.charAt(i+2);
            cs2[i/3] = this.passwordHash.charAt(i+1);
        }
        String salt = new String(cs2);
        return Constants.md5Hex(password+salt).equals(new String(cs1));
    }

    public String generateConfirmToken(){
        long expiration = 1000*60*60*24;
        long curTime = System.currentTimeMillis();
        long activeTime = curTime + expiration;
        JSONObject object = new JSONObject();
        object.put("id",this.id);
        object.put("expiration",activeTime);
        Base64 base64 = new Base64(true);
        return base64.encodeToString(object.toJSONString().getBytes());
    }

    public static Map confirm(String token) throws IOException {
        Base64 base64 = new Base64(true);
        byte []buffer = base64.decode(token);
        String obj = new String(buffer);
        Map model = JSON.parseObject(obj);
        return model;
    }
}
