package com.qinyadan.brick.quartz.service.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 只获取一个实例
 * 
 * @author daily
 * 
 */
public class InstanceControler {

	public static Logger log = LoggerFactory.getLogger(InstanceControler.class);
	// 声明成静态的,为了当类加载之后,将会始终保持当前文件锁
	private static FileLock lock = null;

	@SuppressWarnings("resource")
	public boolean isRunning() {
		try {
			// 获得实例标志文件
			File flagFile = new File("instance");
			// 如果不存在就新建一个
			if (!flagFile.exists())
				flagFile.createNewFile();
			// 获得文件锁
			lock = new FileOutputStream("instance").getChannel().tryLock();
			// 返回空表示文件已被运行的实例锁定
			if (lock != null)
				return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return true;
		}
		return true;
	}

}
