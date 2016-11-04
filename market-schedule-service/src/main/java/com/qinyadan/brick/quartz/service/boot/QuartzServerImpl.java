package com.qinyadan.brick.quartz.service.boot;

import static com.qinyadan.brick.quartz.service.model.TaskTypeEnum.CronDubbo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronExpression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.qinyadan.brick.quartz.service.impl.QuartzDataServiceImpl;
import com.qinyadan.brick.quartz.service.impl.QuartzTaskServiceImpl;
import com.qinyadan.brick.quartz.service.lock.RedisLock;
import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.model.TaskTypeEnum;
import com.qinyadan.brick.quartz.service.utils.CommonUtils;
import com.qinyadan.brick.quartz.service.utils.FailCode;
import com.qinyadan.brick.quartz.service.utils.MD5;
import com.qinyadan.brick.quartz.service.utils.ResultUtils;
import com.qinyadan.brick.quartz.service.zk.ZKCacheUtil;
import com.qinyadan.brick.schedule.api.v1.ScheduleService;
import com.qinyadan.brick.schedule.model.v1.QuartzInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoListResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoPaginate;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoPaginateResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoQueryCondition;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoResult;
import com.qinyadan.brick.schedule.model.v1.QuartzSimpleInfo;
import com.qinyadan.brick.schedule.model.v1.Result;
import com.qinyadan.brick.schedule.model.v1.ServEndpointInfo;
import com.qinyadan.brick.schedule.model.v1.ServEndpointInfoListResult;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfo;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetail;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetailListResult;

/**
 * dubbo接口实现，发布成服务等待调用
 */
@Transactional
public class QuartzServerImpl implements ScheduleService{
	
	private static final Logger log = LoggerFactory.getLogger(QuartzServerImpl.class);

	@Autowired
	private QuartzDataServiceImpl dataService;

	@Autowired
	private QuartzTaskServiceImpl taskService;
	
	@Resource
	private RedisLock redisLock;
	
	/**
	 * 添加定时 任务
	 * @param info
	 * @return
	 */
	@Override
	public QuartzInfoResult addCronTask(QuartzSimpleInfo simpleInfo) {
		if (StringUtils.isEmpty(simpleInfo.getServName()) 
				|| StringUtils.isEmpty(simpleInfo.getTaskDes())
				|| StringUtils.isEmpty(simpleInfo.getTaskExpress()) 
				|| !CronExpression.isValidExpression(simpleInfo.getTaskExpress())) {
			return ResultUtils.failQuartzResult(-1, FailCode.PARAM_ERROR);
		}
		
		QuartzInfo info = DubboTaskInfo.getQuartzInfoFromSimpleInfo(simpleInfo);
		String key = MD5.digest("addCronTask-" + info.getTaskName());
		// 方法锁验证
		if (!redisLock.acquireLock(key)) {
			log.info("addCronTask方法已经被调用，返回系统异常");
			return ResultUtils.failQuartzResult(-3, FailCode.SYSTEM_EXCEPTION);
		}
	
		try {
			if(StringUtils.isBlank(info.getTaskName())){
				return ResultUtils.failQuartzResult(-1, FailCode.TASKNAME_NOT_CONFORM_RULE);
			}
			
			//查询是否存在
			if (null != dataService.getRunningTaskByTaskName(CronDubbo ,info.getTaskName())) {
				return ResultUtils.failQuartzResult(-2, FailCode.TASK_ALREADY_EXIST);
			}
			
			DubboTaskInfo newInfo = new DubboTaskInfo(info);
			newInfo.setTaskGroup(CronDubbo.getValue());
			//添加
			if (!dataService.add(newInfo)) {
				return ResultUtils.failQuartzResult(-3, FailCode.DATABASE_EXCEPTION);
			}
			
			//刷新quartz任务
			taskService.reflash();
			
			return ResultUtils.successQuartzResult(newInfo.covertToResult());
		} catch (Exception e) {
			return ResultUtils.failQuartzResult(-3, FailCode.SYSTEM_EXCEPTION);
		} finally {
			redisLock.releaseLock(key);
		}
	}
	
	/**
	 * 更新定时 任务
	 * @param info
	 * @return
	 */
	@Override
	public QuartzInfoResult updateCronTask(QuartzSimpleInfo simpleInfo) {
		if (StringUtils.isEmpty(simpleInfo.getServName()) 
				|| StringUtils.isEmpty(simpleInfo.getTaskDes())
				|| StringUtils.isEmpty(simpleInfo.getTaskExpress()) 
				|| !CronExpression.isValidExpression(simpleInfo.getTaskExpress())) {
			return ResultUtils.failQuartzResult(-1, FailCode.PARAM_ERROR);
		}
		
		QuartzInfo info = DubboTaskInfo.getQuartzInfoFromSimpleInfo(simpleInfo);
		try {
			//查询是否存在
			DubboTaskInfo task = dataService.getRunningTaskByTaskName(CronDubbo ,info.getTaskName());
			if (null == task) {
				return ResultUtils.failQuartzResult(-2, FailCode.TASK_NOT_EXIST);
			}
			
			DubboTaskInfo newInfo = new DubboTaskInfo(info);
			newInfo.setTaskId(task.getTaskId());
			newInfo.setCreateTime(task.getCreateTime());
			newInfo.setTaskStatus(task.getTaskStatus());
			newInfo.setTaskGroup(task.getTaskGroup());
			//更新
			if (!dataService.update(newInfo)) {
				return ResultUtils.failQuartzResult(-3, FailCode.DATABASE_EXCEPTION);
			}
			
			//刷新quartz任务
			taskService.reflash();
			return ResultUtils.successQuartzResult(newInfo.covertToResult());
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtils.failQuartzResult(-3, FailCode.SYSTEM_EXCEPTION);
		}  
	}
	
	/**
	 * 添加延时任务
	 * @param info
	 * @return
	 */
	@Override
	public QuartzInfoResult addDelayOnceTask(QuartzSimpleInfo simpleInfo) {
		if (StringUtils.isEmpty(simpleInfo.getServName()) 
				|| StringUtils.isEmpty(simpleInfo.getTaskDes())
				|| StringUtils.isEmpty(simpleInfo.getTaskExpress())) {
			return ResultUtils.failQuartzResult(-1, FailCode.PARAM_ERROR);
		}
		
		QuartzInfo info = DubboTaskInfo.getQuartzInfoFromSimpleInfo(simpleInfo);
		
		String key = MD5.digest("addCronTask-" + info.getTaskName());
		// 方法锁验证
		if (!redisLock.acquireLock(key)) {
			log.info("addDelayOnceTask方法已经被调用，返回系统异常");
			return ResultUtils.failQuartzResult(-3, FailCode.SYSTEM_EXCEPTION);
		}
	
		try {
			if(StringUtils.isBlank(info.getTaskName())){
				return ResultUtils.failQuartzResult(-1, FailCode.TASKNAME_NOT_CONFORM_RULE);
			}
			
			DubboTaskInfo task = dataService.addDelayTask(info);
			//刷新quartz任务
			taskService.reflash();
			
			return ResultUtils.successQuartzResult(task.covertToResult());
		} catch (Exception e) {
			return ResultUtils.failQuartzResult(-3, FailCode.SYSTEM_EXCEPTION);
		} finally {
			redisLock.releaseLock(key);
		}
	}
	
	/**
	 * 查询定时任务
	 * @param quartzInfoQueryCondition
	 * @return
	 */
	@Override
	public QuartzInfoPaginateResult quartzInfoQuery (QuartzInfoQueryCondition quartzInfoQueryCondition) {
		QuartzInfoPaginateResult result = new QuartzInfoPaginateResult();
		QuartzInfoPaginate quartzInfoPaginate = new QuartzInfoPaginate();
		quartzInfoPaginate.setTotal(0);
		result.setResult(ResultUtils.successResult());
		try {
			//处理分页信息
			String taskName = quartzInfoQueryCondition.getTaskName();
			int total = dataService.getTaskCount(TaskTypeEnum.CronDubbo.getValue(),taskName);
			if (0 == total) {
				result.setQuartzInfoPaginate(quartzInfoPaginate);
				return result;
			}
			
			int[] paginate = CommonUtils.dealPaginate(total, quartzInfoQueryCondition.getPage(), quartzInfoQueryCondition.getPerPage());
			List<QuartzInfo> quartzInfoList = dataService.getTaskList(TaskTypeEnum.CronDubbo.getValue(),
					quartzInfoQueryCondition.getTaskName(), (paginate[0] - 1) * paginate[1], paginate[1]);
			
			quartzInfoPaginate.setTotal(total);
			quartzInfoPaginate.setPage(paginate[0]);
			quartzInfoPaginate.setPerPage(paginate[1]);
			quartzInfoPaginate.setPageCount(paginate[2]);
			quartzInfoPaginate.setQuartzInfo(quartzInfoList);
			
			result.setQuartzInfoPaginate(quartzInfoPaginate);
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(ResultUtils.failureResult(FailCode.SYSTEM_EXCEPTION));
			return result;
		}
		
		return result;
	}
	
	
	/**
	 * 根据服务名查询 服务器权重信息
	 * @param servName 服务名 为空时默认查询所有信息
	 * @return ServWeightInfoDetailResult
	 */
	@Override
	public ServWeightInfoDetailListResult quertServWeightByServName (String servName) {
		ServWeightInfoDetailListResult result = new ServWeightInfoDetailListResult();
		result.setTotal(0);
		result.setResult(ResultUtils.successResult());
		
		Map<String,List<ServWeightInfo>> servWeight = ZKCacheUtil.getServerWeightCache();
		if (null == servWeight) {
			return result;
		}
		
		List<ServWeightInfoDetail> servWeightInfoDetailList = new ArrayList<ServWeightInfoDetail>();
		
		//条件为空时  全部返还
		if (StringUtils.isEmpty(servName)) {
			for (String name : servWeight.keySet()) { 
				ServWeightInfoDetail model = new ServWeightInfoDetail();
				model.setServName(name);
				model.setServWeightInfoList(servWeight.get(name));
				servWeightInfoDetailList.add(model);
			} 
		} else { //servName 不为空时 模糊查询
			for (String name : servWeight.keySet()) { 
				if (!name.toLowerCase().contains(servName.toLowerCase())) {
					continue;
				}
				ServWeightInfoDetail model = new ServWeightInfoDetail();
				model.setServName(name);
				model.setServWeightInfoList(servWeight.get(name));
				servWeightInfoDetailList.add(model);
			}
		}
		result.setTotal(servWeightInfoDetailList.size());
		result.setServWeightInfoDetailList(servWeightInfoDetailList);
		
		return result;
	}
	
	/**
	 * 查询所有服务 endpoint信息 
	 * （对外暴露的http接口信息）
	 * @return ServEndpointInfoListResult
	 */
	@Override
	public ServEndpointInfoListResult queryServEndPointInfo () {
		ServEndpointInfoListResult result = new ServEndpointInfoListResult();
		result.setTotal(0);
		result.setResult(ResultUtils.successResult());
		Map<String,List<String>> endPoint = ZKCacheUtil.getServEndPoint();
		if (null == endPoint) {
			return result;
		}
		
		List<ServEndpointInfo> servEndpointInfoList = new ArrayList<ServEndpointInfo>();
		for (String servName : endPoint.keySet()) {
			ServEndpointInfo model = new ServEndpointInfo();
			model.setServName(servName);
			model.setEndPointList(endPoint.get(servName));
			servEndpointInfoList.add(model);
		}
		result.setTotal(servEndpointInfoList.size());
		result.setServEndpointInfoList(servEndpointInfoList);
		
		return result;
	}
	
	/**
	 * 更新 服务对应服务器权重信息
	 * @param servWeightInfoDetail 服务器权重信息
	 * @return Result
	 */
	@Override
	public Result updateServWeight (ServWeightInfoDetail servWeightInfoDetail) {
		if (null == servWeightInfoDetail) {
			return ResultUtils.failureResult(FailCode.PARAM_ERROR);
		}
		String servName = servWeightInfoDetail.getServName();
		List<ServWeightInfo> list = servWeightInfoDetail.getServWeightInfoList();
		for (ServWeightInfo info : list) {
			if (StringUtils.isEmpty(info.getIp()) || StringUtils.isEmpty(info.getWeight())) {
				return ResultUtils.failureResult(FailCode.PARAM_ERROR);
			}
		}
		
		int code = ZKCacheUtil.updateServWeight(servName, list);
		if (1 == code) { //参数错误
			return ResultUtils.failureResult(FailCode.PARAM_ERROR);
		} else if (2 == code) {
			return ResultUtils.failureResult(FailCode.SERV_IP_NUM_ERROR);
		}
		
		return ResultUtils.successResult();
	}
	
	/**
	 * 删除尚未执行的延迟任务
	 * @param taskName
	 * @return
	 */
	@Override
	public Result removeDelayOnceTask(String taskName) {
		try{
			if (!dataService.deleteRunningByTaskname(TaskTypeEnum.DelayDubbo,taskName)) {
				return ResultUtils.failureResult(FailCode.TASKINFO_NOT_FOUND);
			}
			
			taskService.reflash();  //不需要刷新，依靠定时同步更新
		} catch(Exception e){
			return ResultUtils.failureResult(FailCode.SYSTEM_EXCEPTION);
		} 

		return ResultUtils.successResult();
	}
	
	/**
	 * 停止正在执行的任务
	 * @param taskName  任务名称
	 * @return Result
	 */
	@Override
	public Result stopCronTask(String taskName) {
		try{
			if (!dataService.stopRunningByTaskname(TaskTypeEnum.CronDubbo,taskName)) {
				return ResultUtils.failureResult(FailCode.TASKINFO_NOT_FOUND);
			}
			
			taskService.reflash();   
		} catch(Exception e){
			return ResultUtils.failureResult(FailCode.SYSTEM_EXCEPTION);
		} 
		
		return ResultUtils.successResult();
	}
	
	/**
	 * 启用已停止的任务
	 * @param taskName 任务名称
	 * @return Result
	 */
	@Override
	public Result runningCronTask(String taskName) {
		try{
			if (!dataService.runningByTaskname(TaskTypeEnum.CronDubbo,taskName)) {
				return ResultUtils.failureResult(FailCode.TASKINFO_NOT_FOUND);
			}
			
			//刷新定时
			taskService.reflash();
			
		} catch(Exception e){
			return ResultUtils.failureResult(FailCode.SYSTEM_EXCEPTION);
		} 
		
		return ResultUtils.successResult();
	}
	
	
	/**
	 * 获取正在运行的任务信息
	 * @param taskName
	 * @return
	 */
	@Override
	public QuartzInfoListResult getRunningTaskByTaskName(String taskName) {
		QuartzInfoListResult result = new QuartzInfoListResult();
		try {
			List<DubboTaskInfo> taskInfos = dataService.getRunningTaskByTaskName(taskName);
			
			if (null == taskInfos || 0 == taskInfos.size()) {
				result.setResult(ResultUtils.failureResult(FailCode.TASKINFO_NOT_FOUND));
				return result;
			}
			
			List<QuartzInfo> resultInfo = new ArrayList<QuartzInfo>();
			for(DubboTaskInfo taskInfo : taskInfos){
				resultInfo.add(taskInfo.covertToResult());
			}
			result.setTotal(taskInfos.size());
			result.setQuartzInfo(resultInfo);
			result.setResult(ResultUtils.successResult());
			
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(ResultUtils.failureResult(FailCode.SYSTEM_EXCEPTION));
			return result;
		}
	}
	
}
