package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;
import java.util.List;

public class OrganizationModel implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -981832430386659835L;
	private Integer id;
    private String name;
    private String description;
    private Integer parentId;
    private String parentName;
    private List<OrganizationModel> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List<OrganizationModel> getNodes() {
        return nodes;
    }

    public void setNodes(List<OrganizationModel> nodes) {
        this.nodes = nodes;
    }
}
