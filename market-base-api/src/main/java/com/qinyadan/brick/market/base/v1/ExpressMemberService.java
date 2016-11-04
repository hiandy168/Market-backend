package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CdExpressMember;

public interface ExpressMemberService {
	public void createExpressMember(CdExpressMember createExpress);
	
	public void updateExpressMember(Integer id,CdExpressMember updateExpress);
	
	public void delete(Integer id);
	
}	
