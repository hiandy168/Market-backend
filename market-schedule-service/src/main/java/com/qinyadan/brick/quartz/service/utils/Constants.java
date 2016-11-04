package com.qinyadan.brick.quartz.service.utils;


public class Constants {
	/**
	 * 应用名称
	 */
	public static final String APP_NAME = "quartz_serv";
	
	/**
	 * 日志打印
	 */
	public static final String LOG_LEVEL_ERROR = "error";
	public static final String LOG_LEVEL_INFO = "info";
	public static final String LOG_LEVEL_DEBUG = "debug";
	public static final String LOG_INFO_PREFIX  = "****[" + APP_NAME + "]**** "; 
	public static final String LOG_ERROR_PREFIX = "$$$$[" + APP_NAME + " ERROR]$$$$ ";  
	public static final String LOG_DEBUG_PREFIX = "====[" + APP_NAME + " ERROR]==== ";  
	
	public static final String ALARM_TYPE_NO_SERV_AVAILABLE = "[NO_SERV_AVAILABLE]";
	
	/**
	 * 格式化日志 打印信息
	 * @param logMsg
	 * @param logLevel
	 * @return
	 */
	public static String formatLogMsg(String logMsg,String logLevel) {
		if (null == logMsg) {
			return "";
		}
		
		if(LOG_LEVEL_ERROR.equals(logLevel)){	//异常日志
			return Constants.LOG_ERROR_PREFIX + logMsg;
		}
		if(LOG_LEVEL_INFO.equals(logLevel)){	//info日志
			return Constants.LOG_INFO_PREFIX + logMsg;
		}
		if(LOG_LEVEL_DEBUG.equals(logLevel)){	//debug日志
			return Constants.LOG_DEBUG_PREFIX + logMsg;
		}
		
		return "";
	}
}
