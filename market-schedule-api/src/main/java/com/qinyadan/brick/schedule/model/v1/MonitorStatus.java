package com.qinyadan.brick.schedule.model.v1;

public enum MonitorStatus {
	
	RUNNING(1), 
	STOPPED(2), 
	STOPPED_BY_EXCEPTION(3), 
	ADD(4), 
	DELETE(5), 
	UPDATE(6), 
	COMPLETE(7);

	private final int value;

	private MonitorStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
