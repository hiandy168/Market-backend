package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class CreatePermissionVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5228014284365845719L;
	
	private String permissionCode;
    private String description;
    private Boolean available;

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
