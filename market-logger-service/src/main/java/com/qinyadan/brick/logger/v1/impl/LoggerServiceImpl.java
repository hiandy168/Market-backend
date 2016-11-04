package com.qinyadan.brick.logger.v1.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinyadan.brick.logger.api.v1.LogModel;
import com.qinyadan.brick.logger.api.v1.LoggerService;

public class LoggerServiceImpl implements LoggerService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggerServiceImpl.class);
	
	
	@Override
	public void insertLog(LogModel logModel) {
		logger.info(logModel.getActionName());
	}

}
