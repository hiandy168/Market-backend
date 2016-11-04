package com.qinyadan.brick.quartz.service.lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisLock {
	
    private static final Logger logger = LoggerFactory.getLogger(RedisLock.class);

    private int expireTime = 30 * 60;

    @Autowired
    private JedisPool jedisPool;

    public boolean acquireLock(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            long i = jedis.setnx(key, key);
            if (i == 1) {
            	logger.info("创建key" + key);
                jedis.expire(key, expireTime);
                logger.info("获取锁成功...");
                return true;
            } else {
            	logger.info("key已存在[" + key + "]");
                logger.info("获取锁失败。。。");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取锁失败...");
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

    public boolean releaseLock(String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.del(key);
            logger.info("释放锁成功...");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("释放锁失败...");
            return false;
        } finally {
            jedisPool.returnResource(jedis);
        }
    }

}
