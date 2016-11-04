package com.qinyadan.brick.market.order.model.v1;

import java.io.Serializable;
import java.util.Map;

public class CreatePackingRecord implements Serializable {

	private String upc;
	private Map<String, Integer> packingInfo;// key=orderNo，value=packingId

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public Map<String, Integer> getPackingInfo() {
		return packingInfo;
	}

	public void setPackingInfo(Map<String, Integer> packingInfo) {
		this.packingInfo = packingInfo;
	}

}
