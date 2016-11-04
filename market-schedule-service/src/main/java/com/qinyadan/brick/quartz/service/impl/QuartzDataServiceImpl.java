package com.qinyadan.brick.quartz.service.impl;

import static com.qinyadan.brick.quartz.service.model.TaskTypeEnum.CronDubbo;
import static com.qinyadan.brick.quartz.service.model.TaskTypeEnum.DelayDubbo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qinyadan.brick.quartz.service.dao.TbQuartzTaskDao;
import com.qinyadan.brick.quartz.service.dao.TbQuartzTaskMapper;
import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.model.TaskTypeEnum;
import com.qinyadan.brick.quartz.service.model.TbQuartzTask;
import com.qinyadan.brick.quartz.service.model.TbQuartzTaskExample;
import com.qinyadan.brick.quartz.service.model.TbQuartzTaskExample.Criteria;
import com.qinyadan.brick.schedule.model.v1.QuartzInfo;
import com.qinyadan.brick.schedule.model.v1.QuartzStateEnum;

@Service(value = "dataImpl")
public class QuartzDataServiceImpl {
	
	protected final static  Logger logger = LoggerFactory.getLogger(QuartzDataServiceImpl.class);
	
	@Autowired
	private TbQuartzTaskMapper mapper;
	
	@Autowired
	private TbQuartzTaskDao tbQuartzTaskDao;
	
	/**
	 * 添加任务到数据库, 如数据库中有正在运行的 相同名字的数据 那么更新
	 * @param info
	 * @return
	 */
	public DubboTaskInfo addCronTask(QuartzInfo info) {
		//原始数据
		DubboTaskInfo taskInfo =  getRunningTaskByTaskName(CronDubbo ,info.getTaskName());
		DubboTaskInfo newInfo = new DubboTaskInfo(info);
		
		if(taskInfo!=null){
			newInfo.setTaskId(taskInfo.getTaskId());
			update(newInfo);
		}else{
			newInfo.setTaskGroup(CronDubbo.getValue());
			add(newInfo);
		}
		
		return newInfo;
	}
	
	/**
	 * 添加一次性任务到数据库, 如数据库中有正在运行的 相同名字的数据 那么更新
	 * @param info
	 * @return
	 */
	public DubboTaskInfo addDelayTask(QuartzInfo info) {
		//原始数据
		DubboTaskInfo taskInfo =  getRunningTaskByTaskName(DelayDubbo,info.getTaskName());
		DubboTaskInfo newInfo = new DubboTaskInfo(info);
		if(taskInfo != null){
			newInfo.setTaskId(taskInfo.getTaskId());
			update(newInfo);
		}else{
			newInfo.setTaskGroup(DelayDubbo.getValue());
			add(newInfo);
		}
		return newInfo;
	}
	
	/**
	 * 更新不为空的任务
	 * @param info
	 * @return
	 */
	public boolean update(DubboTaskInfo info){
		try {
			info.setLastUpdateTime(new Date());
			if (QuartzStateEnum.RUNNING.getValue() == info.getTaskStatus()) {
				info.setTaskStatus((byte)QuartzStateEnum.UPDATING.getValue());
			}
			
			if(1 == mapper.updateByPrimaryKeySelective(info.convertToTb())){
				return true;
			}
			
		} catch (Exception e) {
			logger.info("数据"+info+"更新失败....");
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 添加实例
	 * @param info
	 * @return
	 */
	public boolean add(DubboTaskInfo info){
		try {
			info.setCreateTime(new Date());
			info.setLastUpdateTime(info.getCreateTime());
			info.setTaskStatus((byte)QuartzStateEnum.DELETING.getValue());   
//			info.setTaskStatus((byte)QuartzStateEnum.ADDING.getValue());
			TbQuartzTask jobTask =  info.convertToTb();
			
			if(1 == mapper.insertSelective(jobTask)){
				info.setTaskId(jobTask.getTaskId());
				return true;
			}
			
		} catch (Exception e) {
			logger.info("数据"+info+"插入失败....");
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * 根据任务状态获取数据
	 * @return
	 */
	public List<DubboTaskInfo> getTaskList(QuartzStateEnum... status) {
		//遍历所有可变参数
		List<Byte> statusList = new ArrayList<Byte>();
		for(QuartzStateEnum stat : status){
			statusList.add((byte)stat.getValue());
		}
		
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria();
		criteria.andTaskStatusIn(statusList);
		
		//执行查询
		List<TbQuartzTask> taskInfos = mapper.selectByExample(example);
		
		//拼返回结果
		List<DubboTaskInfo> result = new ArrayList<DubboTaskInfo>();
		for(TbQuartzTask task : taskInfos){
			result.add(new DubboTaskInfo(task));
		}
		
		return result;
	}
	
	/**
	 * 根据状态查询 任务数量
	 * @param status
	 * @return
	 */
	public int getTaskCount(String taskGroup, QuartzStateEnum... status) {
		//遍历所有可变参数
		List<Byte> statusList = new ArrayList<Byte>();
		for(QuartzStateEnum stat : status){
			if (null != stat) {
				statusList.add((byte)stat.getValue());
			}
		}
		
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria();
		if (1 <= statusList.size()) {
			criteria.andTaskStatusIn(statusList);
		}
		criteria.andTaskGroupEqualTo(taskGroup);
		
		return mapper.countByExample(example);
	}
	
	/**
	 * 根据名称查询 任务数量
	 * @param taskName
	 * @return
	 */
	public int getTaskCount(String taskGroup, String taskName) {
		
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria();
		if (!StringUtils.isEmpty(taskName)) {
			criteria.andTaskNameLike("%" + taskName + "%");
		} 
		criteria.andTaskGroupEqualTo(taskGroup);
		
		return mapper.countByExample(example);
	}
	
	/**
	 * 分页查询数据
	 * @return
	 */
	public List<QuartzInfo> getTaskList(String taskGroup,
			String taskName, int start, int perPage) {
		//遍历所有可变参数
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("start", start);
		param.put("count", perPage);
		param.put("taskGroup", taskGroup);
		if (null != taskName) {
			param.put("taskName", taskName);
		}
		
		//执行查询
		List<TbQuartzTask> taskInfos = null;
		if (null != taskName) {
			taskInfos = tbQuartzTaskDao.getAllQuartzInfo(param);
		} else {
			taskInfos = tbQuartzTaskDao.getAllQuartzInfoNoStatus(param);
		}
		
		//拼返回结果
		List<QuartzInfo> result = new ArrayList<QuartzInfo>();
		for(TbQuartzTask task : taskInfos){
			result.add(new DubboTaskInfo(task).covertToResult());
		}
		
		return result;
	}
	
	/**
	 * 将数据库中数据置为正在执行删除操作
	 * @param taskId
	 */
	public boolean deleteRunningByTaskname(TaskTypeEnum type,String taskName) {
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria().andTaskStatusEqualTo((byte)QuartzStateEnum.RUNNING.getValue()).andTaskNameEqualTo(taskName);
		if(type != null){
			criteria.andTaskGroupEqualTo(type.getValue());
		}
		
		TbQuartzTask record = new TbQuartzTask();
		record.setTaskStatus((byte)QuartzStateEnum.DELETING.getValue());
		
		int count = mapper.updateByExampleSelective(record, example);
		if(count > 0){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 将正在执行的任务置为 停止状态
	 * @param type  类型
	 * @param taskName 任务名
	 * @return 是否成功
	 */
	public boolean stopRunningByTaskname(TaskTypeEnum type,String taskName) {
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria().andTaskStatusEqualTo((byte)QuartzStateEnum.RUNNING.getValue()).andTaskNameEqualTo(taskName);
		if(type != null){
			criteria.andTaskGroupEqualTo(type.getValue());
		}
		
		TbQuartzTask record = new TbQuartzTask();
		//设置为 正在删除状态  定时线程刷新时 会更新给 STOP 状态
		record.setTaskStatus((byte)QuartzStateEnum.DELETING.getValue());
		if(0 < mapper.updateByExampleSelective(record, example)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 将停止的任务任务置为  运行状态
	 * @param type  类型
	 * @param taskName 任务名
	 * @return 是否成功
	 */
	public boolean runningByTaskname(TaskTypeEnum type,String taskName) {
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		Criteria criteria = example.createCriteria().andTaskStatusEqualTo((byte)QuartzStateEnum.STOP.getValue()).andTaskNameEqualTo(taskName);
		if(type != null){
			criteria.andTaskGroupEqualTo(type.getValue());
		}
		
		TbQuartzTask record = new TbQuartzTask();
		//设置为 正在添加状态  定时线程刷新时 会更新给 RUNNING 状态
		record.setTaskStatus((byte)QuartzStateEnum.ADDING.getValue());
		
		if(0 < mapper.updateByExampleSelective(record, example)){
			return true;
		}
		
		return false;
	}
	
	/**
	 * 根据taskName 获取正在执行的一个任务
	 * @param taskName
	 * @return
	 */
	public DubboTaskInfo getRunningTaskByTaskName(TaskTypeEnum group, String taskName) {
		
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		example.createCriteria().andTaskNameEqualTo(taskName).andTaskGroupEqualTo(group.getValue());
		
		//执行查询
		List<TbQuartzTask> taskInfos = mapper.selectByExample(example);
		
		//如果有值,取第一个
		if(taskInfos != null && taskInfos.size() != 0){
			return new DubboTaskInfo(taskInfos.get(0));
		}
		
		return null;
		
	}
	
	/**
	 * 根据taskName 获取正在执行的一个任务,支持模糊查询
	 * @param taskName
	 * @return
	 */
	public List<DubboTaskInfo> getRunningTaskByTaskName(String taskName) {
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		example.createCriteria().andTaskNameLike("%" + taskName + "%").andTaskStatusEqualTo((byte)QuartzStateEnum.RUNNING.getValue());
		
		//执行查询
		List<TbQuartzTask> taskInfos = mapper.selectByExample(example);
		//如果有值,取第一个
		if(taskInfos !=null && taskInfos.size() != 0){
			List<DubboTaskInfo> resultList = new ArrayList<DubboTaskInfo>();
			for(TbQuartzTask taskInfo : taskInfos){
				resultList.add(new DubboTaskInfo(taskInfo));
			}
			return resultList;
		}
		
		return null;
	}
	
	/**
	 * 根据服务名和状态查询 任务
	 * @param status 状态
	 * @param servName  服务名称
	 * @return List<DubboTaskInfo>
	 */
	public List<DubboTaskInfo> queryByServName(QuartzStateEnum status,String servName) {
		if (StringUtils.isEmpty(servName)) {
			return null;
		}
		
		//拼查询条件
		TbQuartzTaskExample example = new TbQuartzTaskExample();
		example.createCriteria().andTaskStatusEqualTo((byte)status.getValue())
			.andTaskKeyEqualTo(servName);
		
		//执行查询
		List<TbQuartzTask> taskInfos = mapper.selectByExample(example);
		//如果有值,取第一个
		if(taskInfos !=null && taskInfos.size() != 0){
			List<DubboTaskInfo> resultList = new ArrayList<DubboTaskInfo>();
			for(TbQuartzTask taskInfo : taskInfos){
				resultList.add(new DubboTaskInfo(taskInfo));
			}
			return resultList;
		}
		
		return null;
	}

	
	public boolean persistenceTaskStatus(Integer taskId ,QuartzStateEnum statusEnum, String errorMessage){
		TbQuartzTask task = mapper.selectByPrimaryKey(taskId);
		task.setTaskStatus((byte)statusEnum.getValue());
		task.setLastUpdateTime(new Date());
		
		if(1 == mapper.updateByPrimaryKey(task)){
			return true;
		}
		
		return false;
	}
	
	public boolean updateToSuccessStatus(Integer taskId){
		return persistenceTaskStatus(taskId, QuartzStateEnum.RUNNING, null);
	}
	
	public boolean updateToSuccessStopStatus(Integer taskId){
		return persistenceTaskStatus(taskId, QuartzStateEnum.STOP, null);
	}
	
	public boolean updateToSuccessStopStatus(Integer taskId , String message){
		return persistenceTaskStatus(taskId, QuartzStateEnum.STOP, message);
	}
	
	public boolean updateToFailStatus(Integer taskId, String errorMessage){
		return persistenceTaskStatus(taskId, QuartzStateEnum.ABNORMALSTOP, errorMessage);
	}
	
	public boolean updateToCompleteStatus(Integer taskId, String errorMessage){
		return persistenceTaskStatus(taskId, QuartzStateEnum.COMPLETED, errorMessage);
	}

}
