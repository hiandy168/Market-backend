package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysUsers implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8771255771315666132L;
	

	/**
     * 
     */
    private Integer id;

    /**
     * 登陆用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realname;

    /**
     * 密码盐值
     */
    private String salt;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 1-男，2女
     */
    private Integer sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * QQ
     */
    private String qq;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 办公室电话
     */
    private String officeTel;

    /**
     * 0-禁用，1-启用
     */
    private Integer locked;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(id == null){
              return;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        if(username == null){
              return;
        }
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
        if(realname == null){
              return;
        }
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
        if(salt == null){
              return;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        if(password == null){
              return;
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        if(age == null){
              return;
        }
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
        if(sex == null){
              return;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        if(email == null){
              return;
        }
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
        if(qq == null){
              return;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        if(phoneNumber == null){
              return;
        }
    }

    public String getOfficeTel() {
        return officeTel;
    }

    public void setOfficeTel(String officeTel) {
        this.officeTel = officeTel;
        if(officeTel == null){
              return;
        }
    }

    public Integer getLocked() {
        return locked;
    }

    public void setLocked(Integer locked) {
        this.locked = locked;
        if(locked == null){
              return;
        }
    }
}