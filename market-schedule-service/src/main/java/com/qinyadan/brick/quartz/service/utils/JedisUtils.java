package com.qinyadan.brick.quartz.service.utils;

/**
 * jedis工具类
 * 1.可以直接通过queueLpush方法进行订单状态更新通知
 * 2.可以通过getInstance、getJedis方法获取Jedis实例后自行实现需求
 */
public class JedisUtils  {  
    /*private static final Log log = LogFactory.getLog(JedisUtils.class);  
    private JedisPool pool;
    @Resource
    ConfigManager configManager;
    
    *//** 
     * 不允许实例化，初始化连接池
     *//*
    private JedisUtils(){
        InputStream is = null;
        
        try{
        	// 设置redis基本设置
	    	JedisPoolConfig config = new JedisPoolConfig();  
//	        config.setMaxActive(Integer.parseInt(PropertiesUtil.getProperty("trade_common","redis.maxActive")));  
	        config.setMaxIdle(Integer.parseInt(PropertiesUtil.getProperty("trade_common","redis.maxIdle")));  
//	        config.setMaxWait(Integer.parseInt(PropertiesUtil.getProperty("trade_common","redis.maxWait")));  
	        config.setTestOnBorrow(Boolean.parseBoolean(PropertiesUtil.getProperty("trade_common","redis.testOnBorrow")));  
	        
	        // 设置连接用参数
	        String host = configManager.getRedisConfig("trade_public_redis","5.1").getIp();
	        int port = Integer.parseInt(configManager.getRedisConfig("trade_public_redis","5.1").getPort());
	        int timeout = Integer.parseInt(PropertiesUtil.getProperty("trade_common","redis.timeout"));
	        String password = configManager.getRedisConfig("trade_public_redis","5.1").getPwd();
	        
	        // 得到连接池
            pool = new JedisPool(config, host, port, timeout, password);
            log.info("初始化redis连接池成功！");
        } catch(Exception e) {  
            e.printStackTrace();
            log.error("获取redis连接池失败！");
        } finally {
        	try {
        		if(is != null){
        			is.close();
        		}
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    *//**
     * 静态内部类，用于单例模式
     *//*
    private static class SingletonHolder{
    	public static final JedisUtils instance = new JedisUtils();
    }
    
	*//**
	 * 获取实例
	 * @return
	 *//*
    public static JedisUtils getInstance(){
    	return SingletonHolder.instance;
    }
    
    *//**
     * 序列化成给定模式的JSON并保存到redis
     * @param args
     * @return
     *//*
    public static boolean queueLpush(String userId, String orderId, int status){
    	JedisUtils jedisUtils = getInstance();
    	Jedis jedis = jedisUtils.getJedis();
    	
    	// 连接redis失败，返回
    	if(jedis == null){
    		return false;
    	}
    	
    	InputStream is = null;
		try {
        	// 设置要保存的数据
        	Map<String, Object> innerMap = new HashMap<String, Object>();
        	innerMap.put("order_id", orderId);
        	innerMap.put("title", "");
        	innerMap.put("status", status);
        	
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("key", userId);
        	map.put("value", innerMap);
        	
			// 序列化为JSON串
			String json = (String)JSON.toJSONString(map);
			log.info("保存到redis的JSON串为：" + json);
			
			// 保存到redis中
			Transaction transaction = jedis.multi();
			transaction.lpush("order_push", json);
			transaction.exec();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if(is != null){
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			jedisUtils.closeJedis(jedis);
		}
    }
    
    *//** 
     * 获取Redis实例. 
     * @return Redis工具类实例 
     *//*  
    public Jedis getJedis() {  
        Jedis jedis = null;  
        int count = 0;
        
        // 如果获取连接池失败，直接返回
        JedisPool pool = this.getPool();
        if(pool == null){
        	return null;
        }
        
        // 最多重试3次取得jedis实例
        do{  
            try{   
                jedis = pool.getResource();  
            } catch (Exception e) { 
            	pool.returnBrokenResource(jedis);    
            }  
            count++;  
        } while(jedis == null && count < 3);  
        
        return jedis;  
    }  
  
    *//** 
     * 释放redis实例到连接池. 
     * @param jedis redis实例 
     *//*  
    public void closeJedis(Jedis jedis) {  
        if(jedis != null) {  
        	this.getPool().returnResource(jedis);  
        }  
    }

	public JedisPool getPool() {
		return pool;
	}
    */
}  
