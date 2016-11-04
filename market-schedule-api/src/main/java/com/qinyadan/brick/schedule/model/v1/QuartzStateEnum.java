package com.qinyadan.brick.schedule.model.v1;

public enum QuartzStateEnum {

	RUNNING(1), 
	STOP(2), 
	ABNORMALSTOP(3), 
	ADDING(4), 
	DELETING(5), 
	UPDATING(6), 
	COMPLETED(7);

	private final int value;

	private QuartzStateEnum(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}
	public static QuartzStateEnum findByValue(int value) {
	    switch (value) {
	      case 1:
	        return RUNNING;
	      case 2:
	        return STOP;
	      case 3:
	        return ABNORMALSTOP;
	      case 4:
	        return ADDING;
	      case 5:
	        return DELETING;
	      case 6:
	        return UPDATING;
	      case 7:
	        return COMPLETED;
	      default:
	        return null;
	    }
	  }
}
