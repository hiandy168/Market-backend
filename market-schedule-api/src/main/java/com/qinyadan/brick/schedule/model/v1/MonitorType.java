package com.qinyadan.brick.schedule.model.v1;

public enum MonitorType {
	COUNT_MONITOR(1);

	private final int value;

	private MonitorType(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
