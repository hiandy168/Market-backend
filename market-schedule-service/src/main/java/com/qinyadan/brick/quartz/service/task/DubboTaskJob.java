package com.qinyadan.brick.quartz.service.task;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.restlet.resource.ClientResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qinyadan.brick.market.common.httpshell.common.Constants;
import com.qinyadan.brick.quartz.service.impl.QuartzDataServiceImpl;
import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.model.TaskTypeEnum;
import com.qinyadan.brick.quartz.service.utils.MD5Utils;
import com.qinyadan.brick.quartz.service.utils.SpringContextUtil;
import com.qinyadan.brick.quartz.service.zk.ZKCacheUtil;


@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class DubboTaskJob implements Job {
	
	protected static Logger log = LoggerFactory.getLogger(DubboTaskJob.class);
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		JobDataMap jobMap = context.getJobDetail().getJobDataMap();
		DubboTaskInfo info = (DubboTaskInfo) jobMap.get("thriftInfo");
		String url = this.packageUrl(info); //获取url
		String result = "";
		try {
			ClientResource client = new ClientResource(url);
			client.setRetryAttempts(0); //失败不重试
			result = client.get().getText();
			result = "cron 执行远程调用  taskName:" + info.getTaskName() + "; result:" + result + "; url:" + url ;
		} catch (Exception e) {
			e.printStackTrace();
			result = "cron 执行远程调用  taskName:" + info.getTaskName() + "; result:" + e.getMessage() + "; url:" + url ;
			log.error(result);
		} finally {
			context.setResult(result);
		}
		
		//一次性任务 执行后更新为 completed状态
		if (TaskTypeEnum.DelayDubbo.getValue().equals(info.getTaskGroup())) {
			QuartzDataServiceImpl dataImpl = (QuartzDataServiceImpl)SpringContextUtil.getBean("dataImpl");
			dataImpl.updateToCompleteStatus(info.getTaskId(), "completed");
		}
	}
	
	/**
	 * 
	 * @param Zhe800TaskInfo 
	 * @return 定时请求URL 
	 */
	public String packageUrl(DubboTaskInfo info) {
		String url = info.getTaskUrl();
		// 按权重获取服务器地址  负载均衡作用
		String ipPort = ZKCacheUtil.getIpByWeight(info.getTaskKey());  
		
		//开关   !"true"时表示按照库里存的URL调用
		String isRelyZK = "" ; //PropertiesUtil.getProperty("trade-quartz-serv","calltask.rely.zk");
		if (!StringUtils.isEmpty(ipPort) && "true".equals(isRelyZK)) {
			url = "http://" + ipPort + url.substring(url.indexOf('/', "http://".length() + 1));
		}
		
		//Encode 参数
		int index = url.indexOf("?data=") + "?data=".length();
		if (-1 != index) {
			try {
				url = url.substring(0,index) + URLEncoder.encode(url.substring(index,url.length()),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		//下面添加签名
		Long date = System.currentTimeMillis();
		String sign = new MD5Utils(date + Constants.MD5_KEY).getResult();
		url = url.concat("&&date=").concat(date.toString()).concat("&&sign=").concat(sign);
		return url;
	}
	
	
}
