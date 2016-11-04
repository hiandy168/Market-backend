package com.qinyadan.brick.market.base.model.v1;

import java.io.Serializable;
import java.util.List;


public class UpdateCouponCategory implements Serializable {

    private String categoryName;
    
    private Integer categoryType;
   
    private List<CouponCategoryRefModel> categoryRefs;

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

	public List<CouponCategoryRefModel> getCategoryRefs() {
		return categoryRefs;
	}

	public void setCategoryRefs(List<CouponCategoryRefModel> categoryRefs) {
		this.categoryRefs = categoryRefs;
	}
    

}
