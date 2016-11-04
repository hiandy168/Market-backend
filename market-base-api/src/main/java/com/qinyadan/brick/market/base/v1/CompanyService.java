package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CreateCompany;
import com.qinyadan.brick.market.base.model.v1.UpdateCompany;

public interface CompanyService {
	public void createCompany(CreateCompany createCompany);
	
	public void updateCompany(Integer id,UpdateCompany updateCompany);
	
	public void delete(Integer id);
}	
