package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;


public class CreateOrganization implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2761121222853884504L;
	private String name;
    private String description;

    private Integer parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
