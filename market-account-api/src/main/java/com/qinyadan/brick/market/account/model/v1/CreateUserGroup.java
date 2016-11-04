package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;

public class CreateUserGroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -522966791384288981L;
	
	private String userGroup;
    private String description;
    private Boolean available;

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
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
