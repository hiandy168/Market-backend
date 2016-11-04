package com.qinyadan.brick.quartz.service.impl;

import java.io.Serializable;
import java.util.List;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.model.TaskTypeEnum;
import com.qinyadan.brick.quartz.service.utils.TaskUtils;
import com.qinyadan.brick.schedule.model.v1.QuartzStateEnum;

@Service(value = "taskService")
public class QuartzTaskServiceImpl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected static final Logger log = LoggerFactory.getLogger(QuartzTaskServiceImpl.class);

	@Autowired
	private QuartzDataServiceImpl dataService;
	
	@Autowired
	private TaskUtils taskUtils;

	// 刷新流
	public void reflash() {
		List<DubboTaskInfo> taskList = dataService.getTaskList(QuartzStateEnum.ADDING, QuartzStateEnum.DELETING, QuartzStateEnum.UPDATING);
		for (DubboTaskInfo info : taskList) {
			try {
				switch (TaskTypeEnum.findByValue(info.getTaskGroup())) {
				case CronDubbo:
					cronTaskHandler(info);
					break;
				case DelayDubbo:
					delayTaskHandler(info);
					break;
				default:
					break;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
//				taskFail(TaskTypeEnum.findByValue(info.getTaskGroup()),info.getTaskName(),CommonUtil.getFullExceptionToString(e));
			}

		}

	}
	
	/**
	 * 定时任务执行器,可以封装成Handler,先写在service层
	 */
	public void cronTaskHandler(DubboTaskInfo info) throws Exception{
		
		switch (QuartzStateEnum.findByValue(info.getTaskStatus())) {
		case ADDING:
			taskUtils.addDubboCronJob(info.getTaskName(), info.getTaskExpress(), info);
			dataService.updateToSuccessStatus(info.getTaskId());
			break;
			
		case UPDATING:
			taskUtils.updateDubboCronJob( info.getTaskName(), info.getTaskExpress(), info);
			dataService.updateToSuccessStatus(info.getTaskId());
			break;

		case DELETING:
			taskUtils.deleteDubboJob(TaskTypeEnum.CronDubbo,info.getTaskName());
			dataService.updateToSuccessStopStatus(info.getTaskId());
			break;
		default:
			break;
		}
	}
	
	/**
	 * 延迟任务执行器,可以封装成Handler,先写在service层
	 */
	public void delayTaskHandler(DubboTaskInfo info) throws Exception{
		
		switch (QuartzStateEnum.findByValue(info.getTaskStatus())) {
		case ADDING:
			taskUtils.addDubboDelayJob(info.getTaskName(), info.getTaskExpress(), info);
			dataService.updateToSuccessStatus(info.getTaskId());
			break;
			
		case UPDATING:
			taskUtils.updateDubboDelayJob(info.getTaskName(), info.getTaskExpress(), info);
			dataService.updateToSuccessStatus(info.getTaskId());
			break;

		case DELETING:
			taskUtils.deleteDubboJob(TaskTypeEnum.DelayDubbo,info.getTaskName());
			dataService.updateToSuccessStopStatus(info.getTaskId());
			break;
		default:
			break;
		}
	}
	
	/**
	 * 任务执行失败处理方式
	 * @param taskName
	 * @param error
	 * @return
	 */
	public boolean taskFail(TaskTypeEnum taskGroup ,String taskName,String error){
		
		DubboTaskInfo info = dataService.getRunningTaskByTaskName(taskGroup,taskName);
		log.error("任务"+taskName+"执行失败,开始执行删除任务流程..........");
		dataService.updateToFailStatus(info.getTaskId(), error);
		try {
			taskUtils.deleteDubboJob(taskGroup,info.getTaskName());
			return true;
		} catch (SchedulerException e1) {
			log.error("删除定时任务"+info.getTaskName()+"失败");
			e1.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 任务执行失败处理方式
	 * @param taskName
	 * @param error
	 * @return
	 */
	public boolean taskSuccess(TaskTypeEnum taskGroup ,String taskName,String error){
		DubboTaskInfo info = dataService.getRunningTaskByTaskName(taskGroup,taskName);
		log.error("任务"+taskName+"执行成功,开始执行成功执行任务流程..........");
		return dataService.updateToSuccessStopStatus(info.getTaskId(), error);
	}

	/**
	 * 初始化定时任务
	 */
	public void init() {
		List<DubboTaskInfo> taskList = dataService.getTaskList(QuartzStateEnum.RUNNING);
		for (DubboTaskInfo info : taskList) {
			try {
				taskUtils.addDubboCronJob(info.getTaskName(), info.getTaskExpress(), info);
				dataService.updateToSuccessStatus(info.getTaskId());
			} catch (Exception e) {
				e.printStackTrace();
				taskFail(TaskTypeEnum.findByValue(info.getTaskGroup()),info.getTaskName(),e.getMessage());
			}
		}
		taskUtils.start();
		reflash();
	}
	

}
