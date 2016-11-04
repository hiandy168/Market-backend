package com.qinyadan.brick.order.v1.impl;

import java.util.List;

import com.qinyadan.brick.market.common.mybatis.Page;
import com.qinyadan.brick.market.order.api.v1.OrderService;
import com.qinyadan.brick.market.order.model.v1.CreateOrder;
import com.qinyadan.brick.market.order.model.v1.OrderModel;
import com.qinyadan.brick.market.order.model.v1.OrderQuery;
import com.qinyadan.brick.market.order.model.v1.OrderReport;
import com.qinyadan.brick.market.order.model.v1.PayOrder;
import com.qinyadan.brick.market.order.model.v1.RefundOrder;
import com.qinyadan.brick.market.order.model.v1.TbOrder;
import com.qinyadan.brick.market.order.model.v1.UpdateOrder;

public class OrderSerivceImpl implements OrderService {

	@Override
	public Page<OrderModel> getOrderList(OrderQuery orderQuery, Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<OrderModel> getPackageTaskList(OrderQuery orderQuery, Integer limit, Integer offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderModel> getOrderList(OrderQuery orderQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderReport> getOrderReportList(OrderQuery orderQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderModel getOneOrder(OrderQuery orderQuery) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbOrder createOrder(CreateOrder createOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void batchCreateOrder(CreateOrder createOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public TbOrder updateOrder(UpdateOrder updateOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteOrder(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void cancelOrder(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderStatus(String orderNo, String orderStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateOrderStatus(Integer id, String orderStatus) {
		// TODO Auto-generated method stub

	}

	@Override
	public void refundOrder(RefundOrder refundOrder) {
		// TODO Auto-generated method stub

	}

	@Override
	public void payOrder(PayOrder payOrder) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

}
