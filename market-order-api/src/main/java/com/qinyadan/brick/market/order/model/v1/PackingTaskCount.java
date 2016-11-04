package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class PackingTaskCount implements Serializable {

	private Integer actorId;
	private String actorName;
	private Integer totalCount;
	private Integer readyCount;
	private Integer executingCount;
	private Integer finishedCount;

	public Integer getActorId() {
		return actorId;
	}

	public void setActorId(Integer actorId) {
		this.actorId = actorId;
	}

	public String getActorName() {
		return actorName;
	}

	public void setActorName(String actorName) {
		this.actorName = actorName;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getReadyCount() {
		return readyCount;
	}

	public void setReadyCount(Integer readyCount) {
		this.readyCount = readyCount;
	}

	public Integer getExecutingCount() {
		return executingCount;
	}

	public void setExecutingCount(Integer executingCount) {
		this.executingCount = executingCount;
	}

	public Integer getFinishedCount() {
		return finishedCount;
	}

	public void setFinishedCount(Integer finishedCount) {
		this.finishedCount = finishedCount;
	}

}
