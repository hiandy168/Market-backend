package com.qinyadan.brick.quartz.service.utils;

import java.security.AccessControlException;
import java.util.Properties;

import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.utils.PropertiesParser;
import org.springframework.beans.factory.annotation.Value;


public class MyStdSchedulerFactory extends StdSchedulerFactory{
	
	private PropertiesParser cfg;
	
	/*@Autowired
	public ConfigManager configManager;*/
	
	@Value("${org.quartz.dataSource.myDS.URL}")
	private String url;
	
	public void initialize() throws SchedulerException {
        // short-circuit if already initialized
        if (cfg != null) {
            return;
        }
        System.out.println("---init quartz pool ----");
        Properties props = new Properties();
        try {
        	props.put("org.quartz.scheduler.instanceName", "DubboScheduler");
        	props.put("org.quartz.scheduler.instanceId", "AUTO");
        	props.put("org.quartz.scheduler.rmi.export", "false");
        	props.put("org.quartz.scheduler.rmi.proxy", "false");
        	props.put("org.quartz.scheduler.wrapJobExecutionInUserTransaction", "false");

        	props.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        	props.put("org.quartz.threadPool.threadCount", "30");
        	props.put("org.quartz.threadPool.threadPriority", "5");
        	props.put("org.quartz.threadPool.threadsInheritContextClassLoaderOfInitializingThread", "true");

        	props.put("org.quartz.jobStore.misfireThreshold", "60000");
        	props.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");

        	//# cluster 
        	props.put("org.quartz.jobStore.isClustered", "true");
        	props.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
        	props.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        	
        	props.put("org.quartz.jobStore.dataSource", "myDS");
        	props.put("org.quartz.dataSource.myDS.driver", "com.mysql.jdbc.Driver");
        	props.put("org.quartz.dataSource.myDS.URL", url);
        	props.put("org.quartz.dataSource.myDS.user", "root");
        	props.put("org.quartz.dataSource.myDS.password", "root");
        	props.put("org.quartz.dataSource.myDS.maxConnections", "20");   
        	props.put("org.quartz.dataSource.myDS.validationQuery", "select 0 from dual"); 
        } catch (Exception e){
        
        } finally {
        	
        }

        super.initialize(overrideWithSysProps(props));
    }
	
	private Properties overrideWithSysProps(Properties props) {
		Properties sysProps = null;
		try {
			sysProps = System.getProperties();
		} catch (AccessControlException e) {
			getLog().warn(
					"Skipping overriding quartz properties with System properties "
							+ "during initialization because of an AccessControlException.  "
							+ "This is likely due to not having read/write access for "
							+ "java.util.PropertyPermission as required by java.lang.System.getProperties().  "
							+ "To resolve this warning, either add this permission to your policy file or "
							+ "use a non-default version of initialize().", e);
		}

		if (sysProps != null) {
			props.putAll(sysProps);
		}

		return props;
	}
	 
	public void initialize(Properties props) throws SchedulerException {
		this.cfg = new PropertiesParser(props);
	}
}
