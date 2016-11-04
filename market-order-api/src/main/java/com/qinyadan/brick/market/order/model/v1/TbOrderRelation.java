package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;

public class TbOrderRelation implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 扩展类型
     */
    private String refType;

    /**
     * 扩展值
     */
    private String refValue;

    /**
     * 订单编号
     */
    private String orderNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        if(id == null){
              return;
        }
    }

    public String getRefType() {
        return refType;
    }

    public void setRefType(String refType) {
        this.refType = refType;
        if(refType == null){
              return;
        }
    }

    public String getRefValue() {
        return refValue;
    }

    public void setRefValue(String refValue) {
        this.refValue = refValue;
        if(refValue == null){
              return;
        }
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
        if(orderNo == null){
              return;
        }
    }
}