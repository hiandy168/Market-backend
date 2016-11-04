package com.qinyadan.brick.quartz.service.utils;

import java.util.Date;

import com.qinyadan.brick.schedule.model.v1.FailDesc;



/*
 * 错误编码的处理
 */
public class FailCode {
	
	/**
	 * 系统异常
	 */
	public static final FailDesc SYSTEM_EXCEPTION;
	/**
	 * 更新数据库异常
	 */
	public static final FailDesc DATABASE_EXCEPTION;
	/**
	 * 找不到满足条件的任务
	 */
	public static final FailDesc TASKINFO_NOT_FOUND;
	/**
	 * 任务名字不符合规范
	 */
	public static final FailDesc TASKNAME_NOT_CONFORM_RULE;
	/**
	 * 跟新服务器权重时 ip与线上不匹配
	 */
	public static final FailDesc SERV_IP_NUM_ERROR;
	/**
	 * 参数错误
	 */
	public static final FailDesc PARAM_ERROR;
	
	/**
	 * 任务已经存在
	 */
	public static final FailDesc TASK_ALREADY_EXIST;
	/**
	 * 任务不存在
	 */
	public static final FailDesc TASK_NOT_EXIST;
    
    static {
    	SYSTEM_EXCEPTION = new FailDesc("system", "1234500", "系统异常");
    	DATABASE_EXCEPTION = new FailDesc("system", "1234501", "数据库更新异常");
    	TASKINFO_NOT_FOUND = new FailDesc("quartzTaskInfo", "1234502", "找不到满足条件的任务信息");
    	TASKNAME_NOT_CONFORM_RULE = new FailDesc("quartzTaskName", "1234503", "任务名字不符合规范");
    	SERV_IP_NUM_ERROR = new FailDesc("servWeightIpError", "1234504", "服务器地址个数与线上不匹配");
    	PARAM_ERROR = new FailDesc("paramError", "1234505", "有参数为空或错误");
    	TASK_ALREADY_EXIST = new FailDesc("taskAlreadyExist", "1234505", "任务已经存在");
    	TASK_NOT_EXIST = new FailDesc("taskNotExist", "1234505", "任务不存在");
    }

    /**
     * 判断字段是否为空
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isEmpty(String field) {
        if (field == null || field.trim().equals("")) {
            return true;
        }
        return false;
    }

    /**
     * 判断字段是否不为空
     * @param field
     * @return
     */
    public static boolean isNotEmpty(String field) {
        if (field == null || field.trim().equals("")) {
            return false;
        }
        return true;
    }
    
    /**
     * 判断字段是否为空
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isEmpty(int field) {
        if (field == 0) {
            return true;
        }
        return false;
    }

    /**
     * 判断字段是否为空
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isEmpty(long field) {
        if (field == 0l) {
            return true;
        }
        return false;
    }
    
    /**
     * 判断字段是不是为空
     *
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isEmpty(Object field) {
        if (field == null) {
            return true;
        }
        return false;
    }

    /**
     * 判断是不是大于0
     *
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isOver0(int field) {
        if (field <= 0) {
            return false;
        }
        return true;
    }

    /**
     * 判断是不是大于0
     *
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isOver0(String field) {
      /*  if (PriceUtils.strToInt(field) <= 0) {
            return false;
        }
        return true;*/
    	return true;
    }
    
    /**
     * 判断是否是数字
     * @param field 需要验证的字段
     * @return
     */
    public static boolean isDigital(String field) {
        //如果是负数,先去掉负号
        if (field.trim().substring(0, 1).equals("-")) {
            field = field.substring(1, field.length());
        }
        //替换小数点,再模式匹配数字
        if (!field.replace(".", "").matches("\\d*")) {
            return false;
        }
        return true;
    }
    
    /**
     * 判断起始日期是否大于结束日期
     *
     * @param startDate 起始日期
     * @param endDate   结束日期
     * @return
     */
    public static boolean startDateOverEndDate(String startDate, String endDate) {
        //将时间字符串 转成 时间类型("yyyy-MM-dd")
        Date start = DateUtils.str2Date(startDate);
        Date end = DateUtils.str2Date(endDate);
        if (start.after(end)) {
            return true;
        }
        return false;
    }
}
