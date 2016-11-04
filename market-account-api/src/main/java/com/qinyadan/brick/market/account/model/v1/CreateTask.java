package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;


public  class CreateTask implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6534078232882743849L;
	
	private Integer taskHeadId;
    private Integer executorId;
    
    
	public Integer getTaskHeadId() {
		return taskHeadId;
	}
	public void setTaskHeadId(Integer taskHeadId) {
		this.taskHeadId = taskHeadId;
	}
	public Integer getExecutorId() {
		return executorId;
	}
	public void setExecutorId(Integer executorId) {
		this.executorId = executorId;
	}
    
}
