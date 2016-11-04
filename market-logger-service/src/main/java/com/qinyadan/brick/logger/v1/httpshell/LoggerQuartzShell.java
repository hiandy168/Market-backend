package com.qinyadan.brick.logger.v1.httpshell;

import com.qinyadan.brick.market.common.httpshell.AbstractResource;

public class LoggerQuartzShell extends AbstractResource {

	@Override
	public String deal(String data) {
		System.out.println("task exxcute!");
		return result(0, "success");
	}

}
