package com.qinyadan.brick.market.base.v1;

import com.qinyadan.brick.market.base.model.v1.CdCouponCategory;
import com.qinyadan.brick.market.base.model.v1.CreateCouponCategory;
import com.qinyadan.brick.market.base.model.v1.UpdateCouponCategory;
import com.qinyadan.brick.market.common.mybatis.Page;

public interface CouponCategoryService {
	public Page<CdCouponCategory> getCouponCategoryList(String keyword,Integer categoryType, Integer limit, Integer offset);
	
	public CdCouponCategory getCouponCategory(Integer id);
	
	public CdCouponCategory createCouponCategory(CreateCouponCategory createCouponCategory);
	
	public CdCouponCategory updateCouponCategory(Integer id,UpdateCouponCategory updateCouponCategory);
	
	public void delete(Integer id);
}	
