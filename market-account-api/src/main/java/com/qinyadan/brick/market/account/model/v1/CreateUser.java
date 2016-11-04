package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;
import java.util.List;

public class CreateUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6491646940840368117L;
	
	private String username;
	private String email;
	private String password;
	/**
	 * 真实姓名
	 */
	private String realname;

	/**
	 * 年龄
	 */
	private Integer age;
	/**
	 * 1-男，2女
	 */
	private Integer sex;

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

	private Boolean locked = Boolean.FALSE;

	private Integer organizationId;

	private List<Integer> userGroupIds;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOfficeTel() {
		return officeTel;
	}

	public void setOfficeTel(String officeTel) {
		this.officeTel = officeTel;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public List<Integer> getUserGroupIds() {
		return userGroupIds;
	}

	public void setUserGroupIds(List<Integer> userGroupIds) {
		this.userGroupIds = userGroupIds;
	}

}
