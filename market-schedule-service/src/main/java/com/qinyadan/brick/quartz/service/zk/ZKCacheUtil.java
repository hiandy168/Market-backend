package com.qinyadan.brick.quartz.service.zk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinyadan.brick.market.common.httpshell.common.Constants;
import com.qinyadan.brick.quartz.service.impl.QuartzDataServiceImpl;
import com.qinyadan.brick.quartz.service.model.DubboTaskInfo;
import com.qinyadan.brick.quartz.service.utils.SpringContextUtil;
import com.qinyadan.brick.schedule.model.v1.QuartzStateEnum;
import com.qinyadan.brick.schedule.model.v1.ServWeightInfo;


public class ZKCacheUtil {
	
	protected static final Logger logger = LoggerFactory.getLogger(ZKCacheUtil.class);
	
	/**
	 * 服务器权重 缓存
	 * key:serv名称, 如refund
	 * value:服务器权重列表List
	 */
	private static Map<String,List<ServWeightInfo>> serverWeightCache;
	
	/**
	 * serv EndPoint缓存
	 * key:serv名称
	 * value:endpoint列表List（可访问的http形式接口）
	 */
	private static Map<String,List<String>> servEndPointCache;
	
	/**
	 * 更新服务器权重信息到本地缓存 
	 * @param clientInfo 
	 *   zookeeper中/httpshell/clientinfo 节点信息json格式 [{'servName':'xxx','ip':'xxx'},{..}..]
	 *   ip具体格式为：ip1:isEnable:weight=ip2:isEnable:weight..
	 */
	public static void loadZKClientInfo2Cache (String clientInfo) {
		if (StringUtils.isEmpty(clientInfo)) {
			return ;
		}
		Map<String,List<ServWeightInfo>> cacheMap = new HashMap<String,List<ServWeightInfo>>();
		JSONArray jsonArr = JSONArray.parseArray(clientInfo);
		for (int i = 0; i < jsonArr.size(); i++) {
			JSONObject job = jsonArr.getJSONObject(i);
			String servName = job.getString("servName");
			String ipWeightStr = job.getString("ip_weight");
			
			List<ServWeightInfo> list = new ArrayList<ServWeightInfo>();
			for (String ip : ipWeightStr.split(Constants.HTTP_SHELL_SEPARATOR)) {
				String[] ips = ip.split(":");
				ServWeightInfo model = new ServWeightInfo();
				model.setIp(ips[0].concat(":").concat(ips[1]));
				model.setIsEnable(ips[2]);
				model.setWeight(ips[3]);
				list.add(model);
			}
			
			cacheMap.put(servName, list);
		}
		
		serverWeightCache = cacheMap;
	}
	
	/**
	 * 更新服务器权重信息 到 zookeeper集群
	 */
	public static void updateZKClientInfo2Zk () {
		JSONArray jsonArr = new JSONArray();
		for (String servName : serverWeightCache.keySet()) {
			List<ServWeightInfo> weightList = serverWeightCache.get(servName);
			String ipWeight = "";
			for (ServWeightInfo weight : weightList) {
				if(StringUtils.isEmpty(ipWeight)) {
					ipWeight = ipWeight.concat(weight.getIp()).concat(":")
							.concat(weight.getIsEnable()).concat(":").concat(weight.getWeight());
				} else {
					ipWeight = ipWeight.concat(Constants.HTTP_SHELL_SEPARATOR).concat(weight.getIp())
							.concat(":").concat(weight.getIsEnable()).concat(":").concat(weight.getWeight());
				}
			}
			
			JSONObject job = new JSONObject();
			job.put("servName", servName);
			job.put("ip_weight", ipWeight);
			jsonArr.add(job);
		}
		HttpShellZKUtil.updateClientInfo(jsonArr.toString());
	}
	
	/**
	 * 更新client endpoint信息 到本地缓存
	 * @param servName    servName
	 * @param endpointStr /httpshell/{serName} 节点信息
	 */
	public static void loadZKCLientEndPoint2Cache(String servName,
			String endpointStr) {
		if (StringUtils.isEmpty(servName) || StringUtils.isEmpty(endpointStr)) {
			return;
		}
		
		if (null == servEndPointCache) {
			servEndPointCache = new HashMap<String,List<String>>();
		}
		
		List<String> list = new ArrayList<String>();
		for (String endpoint : endpointStr.split(Constants.HTTP_SHELL_SEPARATOR)) {
			list.add(endpoint);
		}
		
		if (0 != list.size()) {
			servEndPointCache.put(servName, list);
		}
	}
	
	/**
	 * 根据serv名称  按权重获取服务器地址
	 * @param servName
	 * @return ip地址
	 */
	public static String getIpByWeight(String servName) {
		if (null == serverWeightCache || !serverWeightCache.containsKey(servName)) {
			return null;
		}
		
		List<ServWeightInfo> list = serverWeightCache.get(servName);
		int totalWeight = 0;
		for (ServWeightInfo sw : list) {
			if (Constants.HTTP_SHELL_SERV_ENABLE == Integer.valueOf(sw.getIsEnable()) 
					&& !sw.getIp().contains("127.0.0.1")) {
				totalWeight += Integer.valueOf(sw.getWeight());
			}
		}
		
		//无服务器可用 或 权重为0
		if (0 == totalWeight) {
			return null;
		}
		
		String ip = "";
		int count = 0;
		double randNum = Math.random() * totalWeight;  //产生一个随机权重数字
		//匹配随机数 映射到那个具体服务的权重上
		for (ServWeightInfo sw : list) {
			if (Constants.HTTP_SHELL_SERV_DISABLE == Integer.valueOf(sw.getIsEnable())
					|| sw.getIp().contains("127.0.0.1")) {
				continue;
			}
			count += Integer.valueOf(sw.getWeight());
			if (randNum <= count) {
				ip = sw.getIp();
				break;
			}
		}
		return ip;
	}
	
	/**
	 * 更新serv 服务器权重信息
	 * @param servName
	 * @return 0：成功
	 * 		   1：参数为空
	 * 		   2：服务器地址与线上不匹配
	 */
	public static int updateServWeight(String servName, List<ServWeightInfo> list) {
		if (!serverWeightCache.containsKey(servName)) {
			return 1;
		}
		
		List<ServWeightInfo> listW = serverWeightCache.get(servName);
		//根据ip匹配   只更新权重
		List<ServWeightInfo> updateList = new ArrayList<ServWeightInfo>();
		for (ServWeightInfo old : listW) {
			for (ServWeightInfo newW : list) {
				if (old.getIp().trim().equals(newW.getIp().trim())) {
					old.setWeight(newW.getWeight());
					break;
				}
			}
			
			updateList.add(old);
		}
		
		serverWeightCache.put(servName, updateList);  //跟新本地缓存
		updateZKClientInfo2Zk();  			    //更新zookeeper 集群
		return 0;
	}
	
	/**
	 * 获取服务器 endpoint关联信息
	 * @return Map<String,List<String>>
	 */
	public static Map<String, List<String>> getServEndPoint () {
		return servEndPointCache;
	}
	
	/**
	 * 获取权重关联信息 
	 * @return Map<String, List<ServerWeight>>
	 */
	public static Map<String, List<ServWeightInfo>> getServerWeightCache() {
		return serverWeightCache;
	}

	/**
	 * 根据服务名称获取  服务器权重列表
	 * @param servName  服务名
	 * @return List<ServerWeight>
	 */
	public static List<ServWeightInfo> getWeightByServName(String servName) {
		if (StringUtils.isEmpty(servName) || !serverWeightCache.containsKey(servName)) {
			return null;
		}
		return serverWeightCache.get(servName);
	}
	
	/**
	 * 判断某个服务是否全部不可用
	 * @param servName 服务名称
	 */
	public static void judgeServerIsEnable(String servName) {
		if (StringUtils.isEmpty(servName) || !serverWeightCache.containsKey(servName)) {
			return;
		}
		
		List<ServWeightInfo> list = serverWeightCache.get(servName);
		for (ServWeightInfo info : list) {
			//有可用的 即终止执行
			if (info.getIsEnable().equals(Constants.HTTP_SHELL_SERV_ENABLE.toString())) {
				return;
			}
		}
		
		//是否有正在执行的task
		QuartzDataServiceImpl quartzServ = SpringContextUtil.getBean("dataImpl");
		List<DubboTaskInfo> taskInfo = quartzServ.queryByServName(QuartzStateEnum.RUNNING, servName);
		if (null == taskInfo || 1 > taskInfo.size()) {
			return;
		}
		
		//服务servName有正在运行的Task,此时已没有运行的服务器支持  报警
		logger.error(Constants.formatLogMsg("alarm-type:" 
				+ " ALARM_TYPE_NO_SERV_AVAILABLE " + ";servName:" + servName
				, Constants.LOG_LEVEL_ERROR));
		
	}
	
	/**
	 * 打印缓存信息
	 */
	public static void print() {
		System.out.println();
		for (String servName : serverWeightCache.keySet()) {
			System.out.println("serv_weight: servName:" + servName + "; ipWeight:" + serverWeightCache.get(servName));
		}
		
		for (String servName : servEndPointCache.keySet()) {
			System.out.println("serv_endpoint: servName:" + servName + "; endpoint:" + servEndPointCache.get(servName));
		}
		
		System.out.println();
	}
	
	/**
	 * 一些数据结构 测试方法
	 * @param args
	 */
	public static void main(String[] args) {
		/********** 初始化数据 start *************/
		/*ServWeightInfo model = new ServWeightInfo();
		model.setIp("192.168.56.5:8888").setIsEnable("0").setWeight("5");
		ServWeightInfo model1 = new ServWeightInfo();
		model1.setIp("192.168.56.10:8888").setIsEnable("0").setWeight("10");
		ServWeightInfo model2 = new ServWeightInfo();
		model2.setIp("192.168.56.15:8888").setIsEnable("0").setWeight("20");
		ServWeightInfo model3 = new ServWeightInfo();
		model3.setIp("127.0.0.1:8888").setIsEnable("0").setWeight("40");
		List<ServWeightInfo> list = new ArrayList<ServWeightInfo>();
		list.add(model);
		list.add(model1);
		list.add(model2);
		list.add(model3);
		serverWeightCache = new HashMap<String, List<ServWeightInfo>>();
		serverWeightCache.put("refund", list);
		serverWeightCache.put("complain", list);*/
		/********** 初始化数据 end *************/
//		updateZKClientInfo2Zk();
		
//		Map<String,Integer> map = new HashMap<String,Integer>();
//		for (int i = 0; i < 10000; i++) {
//			String ip = getIpByWeight("refund");
//			if (map.containsKey(ip)) {
//				map.put(ip, map.get(ip) + 1);
//			} else {
//				map.put(ip, 1);
//			}
//		}
//		for (String ip : map.keySet()) {//5 10 20 40  
//			System.out.println("----ip:" + ip + "; count:" + map.get(ip) + "; fre:" + map.get(ip)/10000d);
//		}
	}
}
