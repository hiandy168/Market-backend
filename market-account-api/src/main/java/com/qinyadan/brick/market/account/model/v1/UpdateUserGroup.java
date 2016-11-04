package com.qinyadan.brick.market.account.model.v1;


import java.io.Serializable;
import java.util.List;

/**
 * Created by Jeng on 2016/2/1.
 */
public class UpdateUserGroup implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5838898263510100186L;
	
	private String description;
    private List<Integer> userIdList;
    private Boolean available;

    public List<Integer> getUserIdList() {
        return userIdList;
    }

    public void setUserIdList(List<Integer> userIdList) {
        this.userIdList = userIdList;
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
