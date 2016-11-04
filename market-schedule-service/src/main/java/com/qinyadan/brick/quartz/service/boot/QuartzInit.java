package com.qinyadan.brick.quartz.service.boot;

import org.springframework.beans.factory.annotation.Autowired;

import com.qinyadan.brick.market.common.httpshell.zookeeper.ZKManager;
import com.qinyadan.brick.quartz.service.impl.QuartzTaskServiceImpl;
import com.qinyadan.brick.quartz.service.utils.SyncTaskThread;
import com.qinyadan.brick.quartz.service.zk.HttpShellZKUtil;


public class QuartzInit {
	
	@Autowired
	private QuartzTaskServiceImpl taskService;
	
	ZKManager client = new ZKManager("127.0.0.1:2181");
	
	public void start(){
		taskService.init();
		//zookeeper初始化
		HttpShellZKUtil.setZkClient(client.getZkClient());
		HttpShellZKUtil.init();
		
		//启动定时 刷新Task
		int syncTimeInterval = 2000;
		new SyncTaskThread(syncTimeInterval).start();
		
	}
}
