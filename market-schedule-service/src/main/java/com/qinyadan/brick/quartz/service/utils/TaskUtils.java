package com.qinyadan.brick.quartz.service.utils;

import static com.qinyadan.brick.quartz.service.model.TaskTypeEnum.CronDubbo;
import static com.qinyadan.brick.quartz.service.model.TaskTypeEnum.DelayDubbo;

import java.text.ParseException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinyadan.brick.quartz.service.impl.QuartzTaskServiceImpl;
import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.model.TaskTypeEnum;
import com.qinyadan.brick.quartz.service.task.DubboTaskJob;

/**
 * quartz 定时操作
 *
 */
@Service(value = "taskUtils")
public class TaskUtils {
	
	protected static final Logger log = LoggerFactory.getLogger(TaskUtils.class);

	@Autowired 
	private Scheduler scheduler;
	
	@Resource(name="cronDubboJobListener")
	private JobListener cronDubboJobListener;
	
	@Resource(name="delayDubboJobListener")
	private JobListener delayDubboJobListener;

	@Resource
	private QuartzTaskServiceImpl taskService;

	/**
	 * 添加定时Thrift任务
	 * 
	 * @param taskGroup
	 * @param taskName
	 * @param express
	 * @param jobDetailMap
	 * @throws ParseException
	 * @throws SchedulerException
	 */
	public void addDubboCronJob(String taskName, String express, DubboTaskInfo info) throws ParseException,
			SchedulerException {
		TaskTypeEnum taskGroup = CronDubbo;

		log.info("添加CronThriftJob,taskCode:[" + taskGroup + "],taskName:[" + taskName + "],url:[" + info.getTaskUrl() + "]");
		JobDetail job = JobBuilder.newJob(DubboTaskJob.class).withIdentity(taskName, taskGroup.getValue()).build();
		scheduler.getListenerManager().addJobListener(cronDubboJobListener);

		JobDataMap dataMap = job.getJobDataMap();
		dataMap.put("thriftInfo", info);

		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(taskName + "trigger", taskGroup.getValue() + "trigger")
				.withSchedule(CronScheduleBuilder.cronSchedule(express)).build();
		Set<CronTrigger> tr = new HashSet<CronTrigger>() ;
		tr.add(trigger);
		scheduler.scheduleJob(job, tr, true);
	}

	/**
	 * 更新定时Dubbo任务
	 * 
	 * @param taskGroup
	 * @param taskName
	 * @param express
	 * @param jobDetailMap
	 * @throws ParseException
	 * @throws SchedulerException
	 */
	public void updateDubboCronJob(String taskName, String express, DubboTaskInfo info)
			throws ParseException, SchedulerException {
		// 先删除
		deleteDubboJob(CronDubbo , taskName);
		// 后添加
		addDubboCronJob(taskName, express, info);
	}

	/**
	 * 删除定时Thrift任务
	 * 
	 * @param taskGroup
	 * 
	 * @param taskGroup
	 * @param taskName
	 * @throws ParseException
	 * @throws SchedulerException
	 */
	public void deleteDubboJob(TaskTypeEnum taskGroup, String taskName) throws SchedulerException {
		log.info("更新ThriftJob,taskName:[" + taskName + "]");
		TriggerKey triggerKey = new TriggerKey(taskName + "trigger", taskGroup.getValue());
		JobKey jobKey = new JobKey(taskName, taskGroup.getValue());
		scheduler.pauseTrigger(triggerKey);
		scheduler.unscheduleJob(triggerKey);
		scheduler.deleteJob(jobKey);
	}
	
	/**
	 * 创建一次性任务
	 * @param taskGroup
	 * @param taskName
	 * @param express
	 * @param param
	 * @param info
	 * @throws ParseException
	 * @throws SchedulerException
	 */
	public void addDubboDelayJob(String taskName, String seconds, DubboTaskInfo info) throws ParseException,
			SchedulerException {
		TaskTypeEnum taskGroup = DelayDubbo;

		log.info("添加DelayThriftJob,taskCode:[" + taskGroup + "],taskName:[" + taskName + "],url:[" + info.getTaskUrl() + "]");
		JobDetail job = JobBuilder.newJob(DubboTaskJob.class).withIdentity(taskName, taskGroup.getValue()).build();
		scheduler.getListenerManager().addJobListener(delayDubboJobListener);

		JobDataMap dataMap = job.getJobDataMap();
		dataMap.put("thriftInfo", info);
		
		Calendar startTime = Calendar.getInstance();
		if(info.getLastUpdateTime() != null){
			startTime.setTime(info.getLastUpdateTime());
		}
		startTime.add(Calendar.SECOND, Integer.valueOf(seconds));

		SimpleTrigger trigger = (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity(taskName + "trigger", taskGroup.getValue() + "trigger")
				.startAt(startTime.getTime()).build();
		Set<SimpleTrigger> tr = new HashSet<SimpleTrigger>() ;
		tr.add(trigger);
		scheduler.scheduleJob(job, tr, true);
	}
	
	/**
	 * 更新延时Thrift任务
	 * 
	 * @param taskGroup
	 * @param taskName
	 * @param express
	 * @param jobDetailMap
	 * @throws ParseException
	 * @throws SchedulerException
	 */
	public void updateDubboDelayJob(String taskName, String express, DubboTaskInfo info)
			throws ParseException, SchedulerException {
		// 先删除
		deleteDubboJob(CronDubbo, taskName);
		// 后添加
		addDubboDelayJob(taskName, express, info);
	}

	public void start() {
		try {
			scheduler.start();
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
}
