package com.qinyadan.brick.web.schedule;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.qinyadan.brick.schedule.ResultUtils;
import com.qinyadan.brick.schedule.api.v1.ScheduleService;
import com.qinyadan.brick.schedule.model.v1.ListResult;
import com.qinyadan.brick.schedule.model.v1.Result;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetail;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetailListResult;
import com.qinyadan.brick.schedule.model.v1.SuccessedResult;

@RestController
public class WeightListController {

	private static Logger logger = LoggerFactory.getLogger(WeightListController.class);

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping("/weightlist/list")
	public ListResult list(HttpServletRequest request, HttpServletResponse response) {
		ListResult result = new ListResult();

		try {
			String servName = request.getParameter("servName");
			if (StringUtils.isBlank(servName)) {
				servName = "";
			}

			logger.info("开始执行权重列表list方法，servName：" + servName);
			ServWeightInfoDetailListResult servWeightInfoDetailResult = scheduleService
					.quertServWeightByServName(servName);

			result.setRows(servWeightInfoDetailResult.getServWeightInfoDetailList());
			logger.info("权重列表list方法结束，result:" + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping("/weightlist/update")
	public SuccessedResult update(@RequestParam("servWeightInfoDetail") String servWeightInfoDetailJSON) {
		logger.info("开始执行update方法，servWeightInfoDetailJSON：" + servWeightInfoDetailJSON);
		SuccessedResult successedResult = new SuccessedResult();

		try {
			ServWeightInfoDetail servWeightInfoDetail = JSON.parseObject(servWeightInfoDetailJSON,
					ServWeightInfoDetail.class);
			Result result = scheduleService.updateServWeight(servWeightInfoDetail);

			if (result.getCode() == ResultUtils.ERROR_CODE) {
				successedResult.setSuccess(Boolean.FALSE);
				logger.error("update方法执行失败！result:" + successedResult);
				return successedResult;
			}

			successedResult.setSuccess(Boolean.TRUE);
			successedResult.setResult(servWeightInfoDetail.getServName());
			logger.info("update方法执行成功。result:" + successedResult);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return successedResult;
	}

}
