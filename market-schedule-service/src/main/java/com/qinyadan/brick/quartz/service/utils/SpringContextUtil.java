package com.qinyadan.brick.quartz.service.utils;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware{
	
	private static ApplicationContext context = null;

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		this.context = context;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
        return (T) context.getBean(beanName);
    }
	
	public static String getMessage(String key){
        return context.getMessage(key, null, Locale.getDefault());
    }

}
