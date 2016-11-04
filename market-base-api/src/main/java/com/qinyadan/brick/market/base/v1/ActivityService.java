package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CreateActivity;
import com.qinyadan.brick.market.base.model.v1.UpdateActivity;

public interface ActivityService {
	
	public void createActivity(CreateActivity createActivity);

	public void updateActivity(Integer id, UpdateActivity updateActivity);

	public void delete(Integer id);
}
