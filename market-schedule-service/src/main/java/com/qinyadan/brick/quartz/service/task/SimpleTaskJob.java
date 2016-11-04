package com.qinyadan.brick.quartz.service.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class SimpleTaskJob implements Job{
	
	protected static final Logger log = LoggerFactory.getLogger(SimpleTaskJob.class);

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		log.info("传入DataMap:"+ context.getMergedJobDataMap().getKeys().toString());
		log.info("Task 任务 被执行 ");
		
		try {
			int i = 1/0;
		} catch (Exception e) {
			JobExecutionException e2 = new JobExecutionException();
			throw e2;
		}
		/*
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("Task 任务 执行完毕");
		*/
	}

	
}
