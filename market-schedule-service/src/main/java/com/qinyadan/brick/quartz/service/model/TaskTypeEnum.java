package com.qinyadan.brick.quartz.service.model;

public enum TaskTypeEnum {
	
	CronDubbo("DUBBO-CRON"), DelayDubbo("DUBBO-DELAY");

	private String value;

	private TaskTypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static TaskTypeEnum findByValue(String value) {
		if ("DUBBO-CRON".equalsIgnoreCase(value)) {
			return CronDubbo;
		}
		if ("DUBBO-DELAY".equalsIgnoreCase(value)) {
			return DelayDubbo;
		}
		return null;
	}
}
