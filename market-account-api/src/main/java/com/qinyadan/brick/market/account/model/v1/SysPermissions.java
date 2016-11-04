package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class SysPermissions implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -777682819416609364L;
	

	/**
     * 物理主键
     */
    private Integer id;

    /**
     * 权限
     */
    private String permission;

    /**
     * 权限描述
     */
    private String description;

    /**
     * 是否生效：0-禁用，1-启用
     */
    private Integer available;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(id == null){
              return;
        }
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
        if(permission == null){
              return;
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        if(description == null){
              return;
        }
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
        if(available == null){
              return;
        }
    }
}