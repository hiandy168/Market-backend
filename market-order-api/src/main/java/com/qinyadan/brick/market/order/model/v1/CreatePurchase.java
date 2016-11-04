package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Date;

public class CreatePurchase implements Serializable {

    private Date orderDate;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}
