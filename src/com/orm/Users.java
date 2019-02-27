package com.orm;

import java.util.Date;

public class Users {
    private Integer uid;

    private String username;

    private String password;

    private String email;

    private Date lastlogin;

    private Integer role;

    private Date createtime;

    private Integer missnumber;

    private Date misstime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Date getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(Date lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getMissnumber() {
        return missnumber;
    }

    public void setMissnumber(Integer missnumber) {
        this.missnumber = missnumber;
    }

    public Date getMisstime() {
        return misstime;
    }

    public void setMisstime(Date misstime) {
        this.misstime = misstime;
    }
}