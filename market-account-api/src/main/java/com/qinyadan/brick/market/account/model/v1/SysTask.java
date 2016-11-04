package com.qinyadan.brick.market.account.model.v1;

import java.io.Serializable;
import java.util.Date;

public class SysTask implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7788356055629947L;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 任务头ID
	 */
	private Integer taskHeadId;

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
	 * 任务状态：0-待分配，1-待执行，2-执行中，3-已完成，4-已取消
	 */
	private Integer taskStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
		if (id == null) {
			return;
		}
	}

	public Integer getTaskHeadId() {
		return taskHeadId;
	}

	public void setTaskHeadId(Integer taskHeadId) {
		this.taskHeadId = taskHeadId;
		if (taskHeadId == null) {
			return;
		}
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
		if (createTime == null) {
			return;
		}
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
		if (startTime == null) {
			return;
		}
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
		if (finishTime == null) {
			return;
		}
	}

	public Integer getExecutorId() {
		return executorId;
	}

	public void setExecutorId(Integer executorId) {
		this.executorId = executorId;
		if (executorId == null) {
			return;
		}
	}

	public Integer getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
		if (taskStatus == null) {
			return;
		}
	}
	
}