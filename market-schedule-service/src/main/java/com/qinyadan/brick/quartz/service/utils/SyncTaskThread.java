package com.qinyadan.brick.quartz.service.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinyadan.brick.quartz.service.impl.QuartzTaskServiceImpl;



/**
 *  同步任务线程  
 *  固定时间同步数据库 task 到 quartz
 *
 */
public class SyncTaskThread extends Thread {
	
	private static Logger log = LoggerFactory.getLogger(SyncTaskThread.class);
	
	private static final int ONE_SECOND_MS = 1000;  //一毫秒
	private int syncTimeInterval = 30;  			//同步时间间隔  默认60秒
	
	public SyncTaskThread() {
		super();
	}
	
	public SyncTaskThread(int syncTimeInterval) {
		super();
		if (this.syncTimeInterval < syncTimeInterval) {
			this.syncTimeInterval = syncTimeInterval;
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				// 休眠固定时间
				Thread.sleep(syncTimeInterval * ONE_SECOND_MS);
				
				// 刷新任务
				QuartzTaskServiceImpl taskService = SpringContextUtil.getBean("taskService");
				taskService.reflash();
				
				log.info("reflash all task succeed! ");
			} catch (InterruptedException e) {
				log.info("reflash all task failed! ");
				e.printStackTrace();
			}
		}
	}
}
