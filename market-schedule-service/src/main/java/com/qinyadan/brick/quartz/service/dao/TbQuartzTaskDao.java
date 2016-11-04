package com.qinyadan.brick.quartz.service.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qinyadan.brick.market.common.mybatis.BaseDao;
import com.qinyadan.brick.quartz.service.model.TbQuartzTask;

@Repository
public interface TbQuartzTaskDao extends BaseDao<TbQuartzTask>{
	
	public List<TbQuartzTask> getAllQuartzInfo(Map<String,Object> map);
	
	public List<TbQuartzTask> getAllQuartzInfoNoStatus(Map<String,Object> map);
	
}
