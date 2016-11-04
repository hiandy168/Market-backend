package com.qinyadan.brick.quartz.service.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.qinyadan.brick.quartz.service.utils.ResultUtils;
import com.qinyadan.brick.schedule.model.v1.Result;

@Aspect
@Component
public class QuartzLoggerAop{
	
	private static final Logger log = LoggerFactory.getLogger(QuartzLoggerAop.class);
	
	@Pointcut("execution(public * com.zhe800.*.server.Handler.*(..))")
	public void pctMethod() {}
	
	@Around(value="pctMethod()")
	public Object doLogAndTimer(ProceedingJoinPoint pjp) throws Throwable {
		// 打印方法名称
		String mtdName = pjp.getSignature().getName();
		log.info("******开始执行[" + mtdName + "]接口！******");
		this.printParams(pjp.getArgs());

		Object ret = pjp.proceed();

		this.rollBackHandler(pjp.getSignature(), ret);
		
		// 打印方法返回值
		log.info("******执行完毕[" + mtdName + "]接口！******\r\n");
		return ret;
	}
	
	/**
	 * 打印方法参数
	 * @param params
	 * @throws Exception
	 */
	private void printParams(Object... params) throws Exception{
		int i = 0;
		for(Object para : params){
			log.info("参数" + (++i) + ":" + para.toString());
		}
	}
	
	/**
	 * 如果返回的信息中code为1（错误），则回滚
	 * @param ret
	 */
	private void rollBackHandler(Signature signature, Object ret) throws Exception{
		try {
			// 返回的实例中包含Result实例的情况
			Method method = ret.getClass().getDeclaredMethod("getResult");
			Result result = (Result)method.invoke(ret);
			if(result.getCode() == ResultUtils.ERROR_CODE){
				log.error("接口[" + signature.getName() + "]返回失败信息：" + ret.toString());
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
			if(result.getCode() == ResultUtils.SUCCESS_CODE){
				log.info("接口[" + signature.getName() + "]返回成功信息：" + ret.toString());
			}
		} catch (NoSuchMethodException e) {
			// 返回的本身就是Result
			Method method = ret.getClass().getDeclaredMethod("getCode");
			int code = (Integer)method.invoke(ret);
			if(code == ResultUtils.ERROR_CODE){
				log.error("接口[" + signature.getName() + "]返回失败信息：" + ret.toString());
				TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			}
			if(code == ResultUtils.SUCCESS_CODE){
				log.info("接口[" + signature.getName() + "]返回成功信息：" + ret.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.toString());
			throw e;
		}
	}
	
}
