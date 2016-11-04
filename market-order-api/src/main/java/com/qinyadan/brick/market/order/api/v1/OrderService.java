package com.qinyadan.brick.market.order.api.v1;

import java.util.List;

import com.qinyadan.brick.market.common.mybatis.Page;
import com.qinyadan.brick.market.order.model.v1.CreateOrder;
import com.qinyadan.brick.market.order.model.v1.OrderModel;
import com.qinyadan.brick.market.order.model.v1.OrderQuery;
import com.qinyadan.brick.market.order.model.v1.OrderReport;
import com.qinyadan.brick.market.order.model.v1.PayOrder;
import com.qinyadan.brick.market.order.model.v1.RefundOrder;
import com.qinyadan.brick.market.order.model.v1.TbOrder;
import com.qinyadan.brick.market.order.model.v1.UpdateOrder;


public interface OrderService {
	
	public Page<OrderModel> getOrderList(OrderQuery orderQuery, Integer limit, Integer offset);
	
	public Page<OrderModel> getPackageTaskList(OrderQuery orderQuery, Integer limit, Integer offset);
	
	public List<OrderModel> getOrderList(OrderQuery orderQuery);
	
	public List<OrderReport> getOrderReportList(OrderQuery orderQuery);
	
	public OrderModel getOneOrder(OrderQuery orderQuery);
	
	public TbOrder createOrder(CreateOrder createOrder);
	
	public void batchCreateOrder(CreateOrder createOrder);
	
	public TbOrder updateOrder(UpdateOrder updateOrder);
	
	public void deleteOrder(Integer id);
	
	public void cancelOrder(Integer id);
	
	public void updateOrderStatus(String orderNo, String orderStatus);
	
	public void updateOrderStatus(Integer id, String orderStatus);
	
	public void refundOrder(RefundOrder refundOrder);
	
	public void payOrder(PayOrder payOrder) throws IllegalArgumentException;
	
	
}
