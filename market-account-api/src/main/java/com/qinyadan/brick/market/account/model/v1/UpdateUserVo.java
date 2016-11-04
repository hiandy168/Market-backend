package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;
import java.util.List;

public  class UpdateUserVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1337177497734085705L;
	
	private Integer id;
    private String username;
    private String email;
    private String realName;
    private String phoneNumber;
    private Integer age;
    private String qq;
    private String officeTel;
    private Boolean locked;
    /**
     * 1-男，2女
     */
    private Integer sex;
    
    private Integer organizationId;
    
    private List<Integer> userGroupIds;

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
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
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
