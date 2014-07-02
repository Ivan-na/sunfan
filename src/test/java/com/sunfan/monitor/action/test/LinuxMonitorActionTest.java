package com.sunfan.monitor.action.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunfan.monitor.action.LinuxMonitorAction;
import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.service.LinuxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LinuxMonitorActionTest {
	

	@Autowired
	private LinuxMonitorAction monitorAction;
	
	@Test
	public void test() {
		System.out.println(monitorAction.TopAction());;
	}
	
	@Configuration
	public static class BeanConfig{
		
		@Bean
		public LinuxMonitorAction linuxMonitorAction(){
			return new LinuxMonitorAction();
		}
		
		@Bean
		public LinuxService linuxService(){
			return new LinuxService();
		}
		
		@Bean
		public LinuxConnectionPool linuxConnectionPool(){
			return new LinuxConnectionPool();
		}
	}

}
