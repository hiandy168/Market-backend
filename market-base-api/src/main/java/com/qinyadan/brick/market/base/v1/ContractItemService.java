package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CreateContractItem;
import com.qinyadan.brick.market.base.model.v1.UpdateContractItem;

public interface ContractItemService {
	
	public void createContractItem(CreateContractItem createContractItem);
	
	public void updateContractItem(Integer id,UpdateContractItem updateContractItem);
	
	public void delete(Integer id);
}	
