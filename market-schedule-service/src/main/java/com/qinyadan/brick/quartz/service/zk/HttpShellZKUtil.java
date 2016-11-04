package com.qinyadan.brick.quartz.service.zk;

import java.util.List;
import java.util.Set;

import org.I0Itec.zkclient.IZkDataListener;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qinyadan.brick.market.common.httpshell.common.Constants;
import com.qinyadan.brick.market.common.httpshell.zookeeper.ZKDataDealUtil;
import com.qinyadan.brick.market.common.httpshell.zookeeper.ZkClientUtil;


/**
 * 
 *
 *
 *          zookeeper配置相关格式如下, 目录结构如下
 * 
 *          O \ O /httpshell \ O/clientinfo //客户端serv信息，包含服务器权重 | key:clintinfo
 *          |
 *          value:json格式[{'servname:'xx','ip':'ip1:port:enable:weight=ip2:port:
 *          enable:weight'},{..}..] | O/{servname1} //key:服务名 | value:endpoint
 *          |\ | O/temp_{ip1} //服务器标识临时节点 用于监听服务器不可用是状态 | | | O/temp_{ip2} |
 *          O/{servname2} /下一个serv节点 ....
 *
 */
public class HttpShellZKUtil {
	
	private static ZkClientUtil zkClient;
	
	protected static final Logger logger = LoggerFactory.getLogger(HttpShellZKUtil.class);

	/**
	 * 初始化工作 完成一些监听
	 */
	public static void init() {
		String clientInfoNode = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(Constants.HTTP_SHELL_CLIENT_INFO);
		dataListener(clientInfoNode); // 监听client info

		// 获取client
		String clientInfo = getDataValueByKey(clientInfoNode);

		// 添加监听
		childListener(clientInfo);

		// 初始化数据到本地
		syncZK2Cache();
	}

	/**
	 * 注册所有需要加载的项目节点下的配置项数据的监听器
	 * 
	 * @param clientinfo
	 */
	public static void childListener(String clientinfo) {
		try {
			// 先过滤 不满足条件
			if (StringUtils.isEmpty(clientinfo) || StringUtils.isEmpty(clientinfo.trim())) {
				return;
			}

			JSONArray jsonArr = JSONArray.parseArray(clientinfo);
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject job = jsonArr.getJSONObject(i);
				String servName = job.getString("servName");
				String appPath = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(servName);
				// 监听 /httpshell/{client} 数据项
				dataListener(appPath);

				// 监听子节点变化 /httpshell/{client}/temp_{ip}
				List<String> childList = zkClient.getChildren(appPath);
				for (String c : childList) {
					String childPath = appPath.concat("/").concat(c);
					dataListener(childPath);
				}
			}
		} catch (Exception e) {
			logger.error(Constants.formatLogMsg("listen in all data error!", Constants.LOG_LEVEL_ERROR), e);
		}
	}

	/**
	 * 监听具体数据项
	 * 
	 * @param path
	 *            数据项的绝对路径
	 */
	public static void dataListener(String path) {
		try {
			// 先取消之前的监听节点
			Set<IZkDataListener> zkDataListeners = zkClient.getDataListener(path);
			if (zkDataListeners != null) {
				for (IZkDataListener zkDataListener : zkDataListeners) {
					// 取消对该节点的监听
					zkClient.unsubscribeDataChanges(path, zkDataListener);
				}
			}

			// 监听数据变化
			zkClient.subscribeDataChanges(path, new IZkDataListener() {
				// 如果删除某个数据项时触发的事件
				@Override
				public void handleDataDeleted(String dataPath) throws Exception {
					// 获取该节点所有的监听事件，然后取消对该节点的监听
					Set<IZkDataListener> zkDataListeners = zkClient.getDataListener(dataPath);
					if (zkDataListeners != null) {
						for (IZkDataListener zkDataListener : zkDataListeners) {
							// 取消对该节点的监听
							zkClient.unsubscribeDataChanges(dataPath, zkDataListener);
						}
					}
					deleteListenerHandle(dataPath);
					logger.info(Constants.formatLogMsg(dataPath + " is deleted", Constants.LOG_LEVEL_INFO));
				}

				// 如果某个数据项发生变动需要触发的事件
				@Override
				public void handleDataChange(String dataPath, Object data) throws Exception {
					String value = new String((byte[]) data);
					changeListenerHandle(dataPath, value);
					logger.info(
							Constants.formatLogMsg(dataPath + " is changed [" + value + "]", Constants.LOG_LEVEL_INFO));
				}
			});
		} catch (Exception e) {
			logger.error(Constants.formatLogMsg("Create [" + path + "] listener failed", Constants.LOG_LEVEL_ERROR), e);
		}
	}

	/**
	 * 根据数据节点key获取节点值
	 *
	 * @param dataKeyPath
	 *            节点路径 eg:/httpshell/clientinfo
	 * @return 对应节点value
	 */
	public static String getDataValueByKey(String dataKeyPath) {
		if (!zkClient.exists(dataKeyPath)) {
			return null;
		}
		Object data = zkClient.readData(dataKeyPath);
		if (null == data) {
			return null;
		}

		String value = new String((byte[]) data);
		return value;
	}

	/**
	 * 创建目录
	 * 
	 * @param path
	 * @return
	 * @throws Exception
	 */
	public static boolean createDir(String path) throws Exception {
		boolean flag = false;
		try {
			if (!zkClient.exists(path)) {
				zkClient.createPersistent(path, true);
			}
			flag = true;
		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/**
	 * 向节点写数据
	 * 
	 * @param keyPath
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public static boolean writeData(String keyPath, Object value) throws Exception {
		boolean flag = false;
		try {
			if (zkClient.exists(keyPath)) {
				zkClient.writeData(keyPath, value);
			} else {
				zkClient.createPersistent(keyPath, value);
			}
			flag = true;

		} catch (Exception e) {
			throw e;
		}
		return flag;
	}

	/**
	 * 当某个数据项发送改变时, 触发该方法,用来更新 本地缓存
	 * 
	 * @param dataPath
	 *            路径
	 * @param lastDataValue
	 */
	public static void changeListenerHandle(String dataPath, String lastDataValue) {
		// 1.跟新本地缓存
		syncZK2Cache();

		// 2.重新监听节点
		String clientInfoNode = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(Constants.HTTP_SHELL_CLIENT_INFO);
		String clientInfo = getDataValueByKey(clientInfoNode);
		childListener(clientInfo);
	}

	/**
	 * 当节点被删除时 只有服务器停掉时触发 表示该服务器不可用
	 * 
	 * @param dataPath
	 *            临时节点格式：/http/refund/temp_ip
	 */
	public static void deleteListenerHandle(String dataPath) {
		// 校验是否是临时节点
		if (StringUtils.isEmpty(dataPath) || !dataPath.contains(Constants.HTTP_SHELL_TEMP_POINT)) {
			return;
		}

		// 更新服务器可用状态 /httpshell/clientinfo 节点
		String servName = dataPath.split("/")[2];
		String servIp = dataPath.substring(dataPath.indexOf("/" + Constants.HTTP_SHELL_TEMP_POINT)
				+ ("/" + Constants.HTTP_SHELL_TEMP_POINT).length());
		String clientInfo = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(Constants.HTTP_SHELL_CLIENT_INFO);
		String nodeValue = getDataValueByKey(clientInfo);

		nodeValue = ZKDataDealUtil.markServEnable(nodeValue, servName, servIp, Constants.HTTP_SHELL_SERV_DISABLE);
		try {
			writeData(clientInfo, nodeValue.getBytes()); // 更新
			syncZK2Cache(); // 更新本地缓存
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 检查服务对应服务器是否全部不可用 报警
		ZKCacheUtil.judgeServerIsEnable(servName);
	}

	/**
	 * 将zookeeper 信息同步到本地缓存
	 */
	private static void syncZK2Cache() {
		try {
			String clientInfoNode = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(Constants.HTTP_SHELL_CLIENT_INFO);
			// 获取client
			String clientInfo = getDataValueByKey(clientInfoNode);
			ZKCacheUtil.loadZKClientInfo2Cache(clientInfo);

			// 先过滤 不满足条件
			if (StringUtils.isEmpty(clientInfo) || StringUtils.isEmpty(clientInfo.trim())) {
				return;
			}

			JSONArray jsonArr = JSONArray.parseArray(clientInfo);
			for (int i = 0; i < jsonArr.size(); i++) {
				JSONObject job = jsonArr.getJSONObject(i);
				String servName = job.getString("servName");
				String appPath = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(servName);
				ZKCacheUtil.loadZKCLientEndPoint2Cache(servName, getDataValueByKey(appPath));
			}
		} catch (Exception e) {
			logger.error("sync zookeeper info to cache failed! ", e);
		}
	}

	/**
	 * 跟新zookeeper节点 服务器权重信息
	 * 
	 * @param clientInfo
	 * @return
	 */
	public static boolean updateClientInfo(String clientInfo) {
		String clientInfoNode = Constants.ZOOKEEPER_ROOT_PATH.concat("/").concat(Constants.HTTP_SHELL_CLIENT_INFO);
		try {
			createDir(clientInfoNode);
			writeData(clientInfoNode, clientInfo.getBytes());
		} catch (Exception e) {
			logger.error("update serv weight  info to zookeeper failed! ", e);
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static ZkClientUtil getZkClient() {
		return zkClient;
	}

	public static void setZkClient(ZkClientUtil zkClient) {
		HttpShellZKUtil.zkClient = zkClient;
	}
}
