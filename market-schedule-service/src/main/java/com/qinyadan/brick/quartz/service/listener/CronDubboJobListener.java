package com.qinyadan.brick.quartz.service.listener;

import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;

public class CronDubboJobListener implements JobListener{
	
	protected final static Logger log = LoggerFactory.getLogger(CronDubboJobListener.class) ;
	
	public CronDubboJobListener(){
		
	}

	@Override
	public String getName() {
		return "CronDubboListener";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		
		JobDataMap jobMap = context.getMergedJobDataMap();
		DubboTaskInfo info = (DubboTaskInfo) jobMap.get("dubboInfo");
//		log.info("cron 执行远程调用 taskName:" + info.getTaskName() + "; url:" + info.getTaskUrl());
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		String result = context.getResult().toString();
		log.info(result);
	}

}
