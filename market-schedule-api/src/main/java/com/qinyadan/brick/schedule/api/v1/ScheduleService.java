package com.qinyadan.brick.schedule.api.v1;

import com.qinyadan.brick.schedule.model.v1.QuartzInfoListResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoPaginateResult;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoQueryCondition;
import com.qinyadan.brick.schedule.model.v1.QuartzInfoResult;
import com.qinyadan.brick.schedule.model.v1.QuartzSimpleInfo;
import com.qinyadan.brick.schedule.model.v1.Result;
import com.qinyadan.brick.schedule.model.v1.ServEndpointInfoListResult;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetail;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfoDetailListResult;

public interface ScheduleService {

	public QuartzInfoResult addCronTask(QuartzSimpleInfo info) throws Exception;

	public QuartzInfoResult updateCronTask(QuartzSimpleInfo info) throws Exception;

	public Result stopCronTask(String taskName) throws Exception;

	public Result runningCronTask(String taskName) throws Exception;

	public QuartzInfoListResult getRunningTaskByTaskName(String taskName) throws Exception;

	public QuartzInfoPaginateResult quartzInfoQuery(QuartzInfoQueryCondition quartzInfoQueryCondition) throws Exception;

	public ServEndpointInfoListResult queryServEndPointInfo() throws Exception;

	public QuartzInfoResult addDelayOnceTask(QuartzSimpleInfo info) throws Exception;

	public Result removeDelayOnceTask(String taskName) throws Exception;

	public ServWeightInfoDetailListResult quertServWeightByServName(String servName) throws Exception;

	public Result updateServWeight(ServWeightInfoDetail servWeightInfoDetail) throws Exception;
}
