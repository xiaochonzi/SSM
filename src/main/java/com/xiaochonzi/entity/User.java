package com.xiaochonzi.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by stone on 17/6/8.
 */
public class User {
    private Integer id;
    private String email;
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

}
