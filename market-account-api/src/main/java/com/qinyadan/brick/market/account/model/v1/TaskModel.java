package com.qinyadan.brick.market.account.model.v1;


import java.io.Serializable;
import java.util.Date;

public  class TaskModel implements Serializable{
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -7947090738194178365L;

	/**
     * 主键
     */
    private Integer id;

    /**
     * 任务名称
     */
    private String taskName;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 完成时间
     */
    private Date finishTime;

    /**
     * 执行人ID
     */
    private Integer executorId;

    /**
     * 执行人名称
     */
    private String executorName;

    /**
     * 任务状态：0-待分配，1-待执行，2-执行中，3-已完成，4-已取消
     */
    private Integer taskStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Integer getExecutorId() {
		return executorId;
	}

	public void setExecutorId(Integer executorId) {
		this.executorId = executorId;
	}

	public String getExecutorName() {
		return executorName;
	}

	public void setExecutorName(String executorName) {
		this.executorName = executorName;
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}
    
    
}
