package com.qinyadan.brick.web.schedule;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qinyadan.brick.market.common.mybatis.Page;
import com.qinyadan.brick.market.common.mybatis.PageInfo;
import com.qinyadan.brick.schedule.ResultUtils;
import com.qinyadan.brick.schedule.api.v1.ScheduleService;
import com.qinyadan.brick.schedule.model.v1.ListResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoPaginateResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoQueryCondition;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoResult;
import com.qinyadan.brick.schedule.model.v1.QuartzSimpleInfo;
import com.qinyadan.brick.schedule.model.v1.Result;
import com.qinyadan.brick.schedule.model.v1.ServEndpointInfo;
import com.qinyadan.brick.schedule.model.v1.ServEndpointInfoListResult;
import com.qinyadan.brick.schedule.model.v1.SuccessedResult;

@RestController
public class TaskListController {

	private static Logger logger = LoggerFactory.getLogger(TaskListController.class);


	@Autowired
	private ScheduleService scheduleService;

	/**
	 * @param condition
	 * @param limit
	 * @param offset
	 * @return
	 */
	@RequestMapping(value = "/schedule",method = RequestMethod.GET)
	public Page<QuartzInfo> list(@RequestParam(value = "keyword", required = false) String condition, @RequestParam(value = "limit") Integer limit,
            @RequestParam(value = "offset") Integer offset) {
		
		ListResult _result = new ListResult();
		Page<QuartzInfo> result = new Page<QuartzInfo>();
		logger.info("开始执行任务列表list方法，condition：" + condition);
		try {
			QuartzInfoQueryCondition quartzInfoQueryCondition = new QuartzInfoQueryCondition();
			quartzInfoQueryCondition.setPage(offset);
			quartzInfoQueryCondition.setPerPage(limit);
			quartzInfoQueryCondition.setTaskName(condition);
			QuartzInfoPaginateResult quartzInfoPaginateResult = scheduleService
					.quartzInfoQuery(quartzInfoQueryCondition);

			_result.setTotal(quartzInfoPaginateResult.getQuartzInfoPaginate().getTotal());
			_result.setRows(quartzInfoPaginateResult.getQuartzInfoPaginate().getQuartzInfo());
			
			result.setPageSize(_result.getTotal());
			result.setData(quartzInfoPaginateResult.getQuartzInfoPaginate().getQuartzInfo());
			result.setPages(_result.getTotal());
			result.setPageNum(limit);
			
			PageInfo info = new PageInfo();
			info.setPageNum(limit);
			info.setPages(_result.getTotal());
			info.setPageSize(_result.getTotal());
			
			result.setPageInfo(info);
			logger.info("任务列表list方法结束，result:" + result.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "/schedule",method = RequestMethod.POST)
	public SuccessedResult add(@RequestBody QuartzSimpleInfo quartzSimpleInfo,BindingResult bindingResult) {
		logger.info("开始执行add方法，参数：" + quartzSimpleInfo);
		SuccessedResult successedResult = new SuccessedResult();

		try {
			// QuartzSimpleInfo quartzSimpleInfo = JSON.parseObject(quartzSimpleInfoStr, QuartzSimpleInfo.class);
			QuartzInfoResult result = scheduleService.addCronTask(quartzSimpleInfo);

			if (result.getResult().getCode() == ResultUtils.ERROR_CODE && result.getFailCode() == -2) {
				successedResult.setSuccess(Boolean.FALSE);
				successedResult.setResult("existed");
				logger.error("add方法执行失败，已有该任务记录！");
				return successedResult;
			}

			if (result.getResult().getCode() == ResultUtils.ERROR_CODE) {
				successedResult.setSuccess(Boolean.FALSE);
				logger.error("add方法执行失败！result:" + successedResult);
				return successedResult;
			}

			successedResult.setSuccess(Boolean.TRUE);
			logger.error("add方法执行成功。result:" + successedResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return successedResult;
	}

	@RequestMapping("/schedule/{quartzSimpleInfoStr}/update")
	public SuccessedResult update(@RequestParam("quartzSimpleInfo") String quartzSimpleInfoStr) {
		logger.info("开始执行update方法，参数：" + quartzSimpleInfoStr);
		SuccessedResult successedResult = new SuccessedResult();

		try {
			QuartzSimpleInfo quartzSimpleInfo = JSON.parseObject(quartzSimpleInfoStr, QuartzSimpleInfo.class);
			QuartzInfoResult result = scheduleService.updateCronTask(quartzSimpleInfo);
			if (result.getResult().getCode() == ResultUtils.ERROR_CODE) {
				successedResult.setSuccess(Boolean.FALSE);
				logger.error("update方法执行失败！result:" + successedResult);
				return successedResult;
			}

			successedResult.setSuccess(Boolean.TRUE);
			logger.error("update方法执行成功。result:" + successedResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return successedResult;
	}

	@RequestMapping("/schedule/{id}/delete")
	public SuccessedResult delete(HttpServletRequest request, HttpServletResponse response) {
		SuccessedResult successedResult = new SuccessedResult();
		return successedResult;
	}

	@RequestMapping("/schedule/{taskName}/suspend")
	public SuccessedResult suspend(HttpServletRequest request, HttpServletResponse response) {
		SuccessedResult successedResult = new SuccessedResult();
		String taskName = request.getParameter("taskName");
		logger.info("开始执行suspend方法，任务名称：" + taskName);

		try {
			Result stopCronTaskResult = scheduleService.stopCronTask(taskName);
			if (stopCronTaskResult.getCode() == 0) {
				successedResult.setSuccess(Boolean.TRUE);
				logger.info("suspend方法执行成功。result:" + successedResult);
				return successedResult;
			}

		} catch (Exception e) {
			e.printStackTrace();
			successedResult.setSuccess(Boolean.FALSE);
			logger.error("suspend方法执行失败！result:" + successedResult);
		}

		return successedResult;
	}

	@RequestMapping("/schedule/{taskName}/resume")
	public SuccessedResult resume(HttpServletRequest request, HttpServletResponse response) {
		SuccessedResult successedResult = new SuccessedResult();
		String taskName = request.getParameter("taskName");
		logger.info("开始执行resume方法，任务名称：" + taskName);

		try {
			Result runningCronTaskResult = scheduleService.runningCronTask(taskName);
			if (runningCronTaskResult.getCode() == 0) {
				successedResult.setSuccess(true);
				logger.info("resume方法执行成功。result:" + successedResult);
				return successedResult;
			}

		} catch (Exception e) {
			e.printStackTrace();
			successedResult.setSuccess(Boolean.FALSE);
			logger.error("resume方法执行失败！result:" + successedResult);
		}

		return successedResult;
	}

	@RequestMapping("/schedule/servEndPoint")
	public List<ServEndpointInfo> queryServEndPointInfo() {
		logger.info("开始执行queryServEndPointInfo，查询新增任务查询服务名称、方法名称。");
		SuccessedResult successedResult = new SuccessedResult();

		try {
			ServEndpointInfoListResult servEndpointInfoListResult = scheduleService.queryServEndPointInfo();
			if (servEndpointInfoListResult.getResult().getCode() == ResultUtils.ERROR_CODE) {
				successedResult.setSuccess(Boolean.FALSE);
				logger.error("queryServEndPointInfo方法执行错误！result:" + successedResult);
				return null;
			}

			successedResult.setSuccess(Boolean.TRUE);
			successedResult.setResult(servEndpointInfoListResult.getServEndpointInfoList());
			logger.info("queryServEndPointInfo方法执行成功。" + successedResult);
			return servEndpointInfoListResult.getServEndpointInfoList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
