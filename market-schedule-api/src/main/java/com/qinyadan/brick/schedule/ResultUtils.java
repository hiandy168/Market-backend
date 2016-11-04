package com.qinyadan.brick.schedule;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinyadan.brick.schedule.model.v1.FailDesc;
import com.qinyadan.brick.schedule.model.v1.Result;



public class ResultUtils {
	
	private static final Logger log = LoggerFactory.getLogger(ResultUtils.class);
	/** 0:成功 */
	public static final int SUCCESS_CODE = 0;
	/** 1:失败 */
	public static final int ERROR_CODE = 1;
	
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
	public static Result failureResult(String name, String failCode, String desc){
		Result result = new Result();
		List<FailDesc> failDescList = new ArrayList<FailDesc>();
		
		FailDesc failDesc = new FailDesc(name, failCode, desc);
		failDescList.add(failDesc);
		
		result.setCode(ERROR_CODE);
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
	
	/**
	 * 返回包括错误信息的失败Result
	 * @param failDescList
	 * @return
	 */
	public static Result failureResult(List<FailDesc> failDescList){
		Result result = new Result();
		
		result.setCode(ERROR_CODE);
		result.setFailDescList(failDescList);
		
		return result;
	}
	
	/**
	 * 打印错误并返回失败的系统级的Result
	 * @param e
	 * @return
	 */
	public static Result systemErrorResult(Exception e){
		e.printStackTrace();
		log.error("接口发生异常：" + e.toString());
		for(StackTraceElement message : e.getStackTrace()){
			log.error("at " + message);
		}
		Result result = new Result();
		List<FailDesc> failDescList = new ArrayList<FailDesc>();
		
		failDescList.add(FailCode.SYSTEM_EXCEPTION);
		
		result.setCode(ERROR_CODE);
		result.setFailDescList(failDescList);
		
		return result;
	}
	public static void main(String[] args) {
		Map map = System.getenv();
		for ( Iterator it =map.keySet().iterator(); it.hasNext(); )
        {
               String key = (String ) it.next();
               String value = (String )  map.get(key);
               System.out.println(key +":" +value);
        }
	}
}
