package com.cww.mymoxi.model;

import java.util.Date;

public class Admin {
    private Integer id;

    private String username;

    private String password;

    private String realname;

    private Integer age;

    private String phonenumber;

    private String headpicture;

    private Date adddate;

    private Date updatedate;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getHeadpicture() {
        return headpicture;
    }

    public void setHeadpicture(String headpicture) {
        this.headpicture = headpicture == null ? null : headpicture.trim();
    }

    public Date getAdddate() {
        return adddate;
    }

    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Admin() {
    }

    public Admin(Integer id, String username, String password, String realname, Integer age, String phonenumber, String headpicture, Date adddate, Date updatedate, Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.age = age;
        this.phonenumber = phonenumber;
        this.headpicture = headpicture;
        this.adddate = adddate;
        this.updatedate = updatedate;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                ", phonenumber='" + phonenumber + '\'' +
                ", headpicture='" + headpicture + '\'' +
                ", adddate=" + adddate +
                ", updatedate=" + updatedate +
                ", state=" + state +
                '}';
    }
}