package com.qinyadan.brick.schedule.model.v1;

import java.io.Serializable;

public class MonitorTaskInfo implements Serializable{
	  public String monitorId;
	  public String monitorName;
	  public int monitorType;
	  public int monitorStatus;
	  public String executeSql;
	  public int monitorThresholds;
	  public String createTime;
	  public String lastExecuteTime;
	  public String nextExecuteTime;
	  public int nextInterval;

}
