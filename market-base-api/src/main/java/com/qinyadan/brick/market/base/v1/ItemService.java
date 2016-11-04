package com.qinyadan.brick.market.base.v1;



import java.util.List;

import com.qinyadan.brick.market.base.model.v1.CreateItem;
import com.qinyadan.brick.market.base.model.v1.ItemModel;
import com.qinyadan.brick.market.base.model.v1.ItemQuery;
import com.qinyadan.brick.market.base.model.v1.UpdateItem;
import com.qinyadan.brick.market.common.mybatis.Page;

public interface ItemService {

	public List<ItemModel> queryItemList(ItemQuery itemQuery);

	public Page<ItemModel> queryItemList(ItemQuery itemQuery, Integer offset, Integer limit);

	public void createItem(CreateItem createItem);
	
	public void updateItem(Integer id,UpdateItem updateItem);
	
	public void delete(Integer id);
	
}	
