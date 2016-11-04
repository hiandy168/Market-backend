package com.qinyadan.brick.quartz.service.utils;

import java.util.ArrayList;
import java.util.List;

import com.qinyadan.brick.schedule.model.v1.FailDesc;
import com.qinyadan.brick.schedule.model.v1.QuartzInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoResult;
import com.qinyadan.brick.schedule.model.v1.Result;



public class ResultUtils {
	/** 0:成功 */
	public static final int SUCCESS_CODE = 0;
	/** 1:失败 */
	public static final int ERROR_CODE = 1;
	
	public static final String SUCCESS = "调用成功";
	public static final String FAIL = "调用失败";
	
	/**
	 * 返回成功的Result
	 * @return
	 */
	public static Result successResult(){
		Result result = new Result();
		List<FailDesc> failDescList = new ArrayList<FailDesc>();
		result.setCode(SUCCESS_CODE);
		result.setFailDescList(failDescList);
		return result;
	}
	
	/**
	 * 返回包括错误信息的失败Result
	 * @param desc
	 * @return
	 */
	public static Result failureResult(FailDesc... desc){
		Result result = new Result();
		List<FailDesc> failDescList = new ArrayList<FailDesc>();
		
		if(desc != null){
			for(int i = 0; i < desc.length; i++){
				failDescList.add(desc[i]);
			}
		}
		result.setCode(ERROR_CODE);
		result.setFailDescList(failDescList);
		
		return result;
	}
	
	/***********下面是业务相关的 Result start *********************/
	/**
	 * 组装成功的 QuartzInfoResult
	 * @param quartzInfo QuartzInfo
	 * @return  QuartzInfoResult
	 */
	public static QuartzInfoResult successQuartzResult(QuartzInfo quartzInfo) {
		QuartzInfoResult result = new QuartzInfoResult();
		result.setFailCode(SUCCESS_CODE);
		result.setResult(ResultUtils.successResult());
		result.setQuartzInfo(quartzInfo);
		return result;
	}
	
	/**
	 * 组装失败的 QuartzInfoResult
	 * @param failCode 0：成功 -1：参数错误  -2：任务已存在或任务不存在  -3：系统异常
	 * @param desc 错误描述
	 * @return  QuartzInfoResult
	 */
	public static QuartzInfoResult failQuartzResult(int failCode, FailDesc... desc) {
		QuartzInfoResult result = new QuartzInfoResult();
		result.setFailCode(failCode);
		result.setResult(ResultUtils.failureResult(desc));
		return result;
	}
	/***********下面是业务相关的 Result  end  *********************/
}
