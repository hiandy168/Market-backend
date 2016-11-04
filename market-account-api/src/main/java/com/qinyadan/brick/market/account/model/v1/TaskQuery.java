package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;


public  class TaskQuery implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -5969233346698845581L;
	
	private String keyword;
    private Integer[] taskStatus;
    private Integer[] executorIds;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Integer[] getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(Integer[] taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Integer[] getExecutorIds() {
		return executorIds;
	}
	public void setExecutorIds(Integer[] executorIds) {
		this.executorIds = executorIds;
	}
    
    

}
