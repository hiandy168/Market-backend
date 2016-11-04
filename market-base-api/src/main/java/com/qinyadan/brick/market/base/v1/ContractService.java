package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CreateContract;
import com.qinyadan.brick.market.base.model.v1.UpdateContract;

public interface ContractService {
	public void createContract(CreateContract createContract);
	
	public void updateContract(Integer id,UpdateContract updateContract);
	
	public void delete(Integer id);
	
}	
