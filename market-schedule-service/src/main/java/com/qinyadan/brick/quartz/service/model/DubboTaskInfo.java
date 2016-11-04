package com.qinyadan.brick.quartz.service.model;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import com.qinyadan.brick.quartz.service.utils.DateUtils;
import com.qinyadan.brick.quartz.service.zk.ZKCacheUtil;
import com.qinyadan.brick.schedule.model.v1.QuartzInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzSimpleInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzStateEnum;

public class DubboTaskInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer taskId;
	private String taskName;
	private String taskGroup;
	private String taskDes;
	private String taskUrl;
	private String taskExpress;
	private String taskKey;
	private Byte   taskStatus;
	private Date createTime;
	private Date lastUpdateTime;
	
	public DubboTaskInfo() {
		super();
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskGroup() {
		return taskGroup;
	}
	public void setTaskGroup(String taskGroup) {
		this.taskGroup = taskGroup;
	}
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	public String getTaskUrl() {
		return taskUrl;
	}
	public void setTaskUrl(String taskUrl) {
		this.taskUrl = taskUrl;
	}
	public String getTaskExpress() {
		return taskExpress;
	}
	public void setTaskExpress(String taskExpress) {
		this.taskExpress = taskExpress;
	}
	public String getTaskKey() {
		return taskKey;
	}
	public void setTaskKey(String taskKey) {
		this.taskKey = taskKey;
	}
	public Byte getTaskStatus() {
		return taskStatus;
	}
	public void setTaskStatus(Byte taskStatus) {
		this.taskStatus = taskStatus;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	
	public DubboTaskInfo(Integer taskId, String taskName, String taskGroup,
			String taskDes, String taskUrl, String taskExpress, String taskKey,
			Byte taskStatus, Date createTime, Date lastUpdateTime) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskGroup = taskGroup;
		this.taskDes = taskDes;
		this.taskUrl = taskUrl;
		this.taskExpress = taskExpress;
		this.taskKey = taskKey;
		this.taskStatus = taskStatus;
		this.createTime = createTime;
		this.lastUpdateTime = lastUpdateTime;
	}
	
	
	public DubboTaskInfo(TbQuartzTask tbQuartzTask) {
		this.setTaskId(tbQuartzTask.getTaskId());
		this.setTaskStatus(tbQuartzTask.getTaskStatus());
		this.setTaskGroup(tbQuartzTask.getTaskGroup());
		this.setTaskName(tbQuartzTask.getTaskName());
		this.setLastUpdateTime( tbQuartzTask.getLastUpdateTime());
		this.setTaskDes(tbQuartzTask.getTaskDes());
		this.setCreateTime(tbQuartzTask.getCreateTime());
		this.setTaskKey(tbQuartzTask.getTaskKey());
		this.setTaskExpress(tbQuartzTask.getTaskExpress());
		this.setTaskUrl(tbQuartzTask.getTaskUrl());
	}
	
	public DubboTaskInfo(QuartzInfo quartzInfo) {
		this.setTaskId(quartzInfo.getTaskId());
		if (null != quartzInfo.getTaskStatus()) {
			this.setTaskStatus((byte)quartzInfo.getTaskStatus().getValue());
		}
		this.setTaskGroup(quartzInfo.getTaskGroup());
		this.setTaskName(quartzInfo.getTaskName());
		if (null != quartzInfo.getLastUpdateTime()) {
			this.setLastUpdateTime(DateUtils.strToDateLong(quartzInfo.getLastUpdateTime()));
		}
		this.setTaskDes(quartzInfo.getTaskDes());
		if (null != quartzInfo.getCreateTime()) {
			this.setCreateTime(DateUtils.strToDateLong(quartzInfo.getCreateTime()));
		}
		this.setTaskKey(quartzInfo.getTaskKey());
		this.setTaskExpress(quartzInfo.getTaskExpress());
		this.setTaskUrl(quartzInfo.getTaskUrl());
	}
	
	
	/**
	 * 转化成Tb类型
	 * @return
	 * @throws Exception
	 */
	public TbQuartzTask convertToTb() throws Exception{
		TbQuartzTask task =  new TbQuartzTask();
		task.setTaskId(this.getTaskId());
		task.setTaskStatus(this.getTaskStatus());
		task.setTaskGroup(this.getTaskGroup());
		task.setTaskName(this.getTaskName());
		task.setLastUpdateTime(this.getLastUpdateTime());
		task.setTaskDes(this.getTaskDes());
		task.setCreateTime(this.getCreateTime());
		task.setTaskKey(this.getTaskKey());
		task.setTaskExpress(this.getTaskExpress());
		task.setTaskUrl(this.getTaskUrl());
		return task;
	}
	
	/**
	 * 转化成result
	 * @return
	 */
	public QuartzInfo covertToResult(){
		QuartzInfo info =  new QuartzInfo();
		info.setTaskId(this.getTaskId());
		if (null != this.getTaskStatus()) {
			info.setTaskStatus(QuartzStateEnum.findByValue(this.getTaskStatus()));
		}
		info.setTaskGroup(this.getTaskGroup());
		info.setTaskName(this.getTaskName());
		if (null != this.getLastUpdateTime()) {
			info.setLastUpdateTime(DateUtils.dateToStrLong(this.getLastUpdateTime()));
		}
		info.setTaskDes(this.getTaskDes());
		if (null != this.getCreateTime()) {
			info.setCreateTime(DateUtils.dateToStrLong(this.getCreateTime()));
		}
		info.setTaskKey(this.getTaskKey());
		info.setTaskExpress(this.getTaskExpress());
		info.setTaskUrl(this.getTaskUrl());
		return info;
	}
	
	/**
	 * QuartzSimpleInfo 转换成 QuartzInfo
	 * @param simpleInfo QuartzSimpleInfo
	 * @return QuartzInfo
	 */
	public static QuartzInfo getQuartzInfoFromSimpleInfo(QuartzSimpleInfo simpleInfo) {
		QuartzInfo info = new QuartzInfo();
		info.setTaskExpress(simpleInfo.getTaskExpress());
		info.setTaskKey(simpleInfo.getServName());
		//拼装任务名称   格式为：servName.endpoint
		String taskName = simpleInfo.getTaskName();
		if (taskName.contains("/")) {
			info.setTaskName(simpleInfo.getServName() + "."
					+ taskName.substring(1,taskName.length()));
		} else {
			info.setTaskName(simpleInfo.getServName() + "." + taskName);
		}
		info.setTaskDes(simpleInfo.getTaskDes());
		
		//拼装默认访问URL
		String ipPort= ZKCacheUtil.getIpByWeight(simpleInfo.getServName());
		if (null == ipPort) {
			return null;
		}
		String url = "http://" + ipPort + simpleInfo.getTaskName();
		if (StringUtils.isEmpty(simpleInfo.getTaskParam())) {
			url = url + "?data=null";
		} else {
			url = url + "?data=" + simpleInfo.getTaskParam();
		}
		info.setTaskUrl(url);
		
		return info;
	}
}
