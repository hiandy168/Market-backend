package com.qinyadan.brick.market.base.v1;

import java.util.List;

import com.qinyadan.brick.market.base.model.v1.CdExpress;
import com.qinyadan.brick.market.base.model.v1.ExpressTask;
import com.qinyadan.brick.market.base.model.v1.OrderModel;
import com.qinyadan.brick.market.base.model.v1.OrderQuery;
import com.qinyadan.brick.market.common.mybatis.Page;



public interface ExpressService {
	
	public void createExpress(CdExpress createExpress);
	
	public void updateExpress(Integer id,CdExpress updateExpress);
	
	public void delete(Integer id);
	
	public void dispatchExpress(ExpressTask expressTask);
	
	public void cancelExpress(String[] orderNoList);
	
	public void takeDelivery(String orderNo);
	
	public void unTakeDelivery(String orderNo);
	
	public Page<OrderModel> getTakeDeliveryList(OrderQuery orderQuery, Integer limit, Integer offset);
	
	public List<OrderModel> getTakeDeliveryList(OrderQuery query);
}	
