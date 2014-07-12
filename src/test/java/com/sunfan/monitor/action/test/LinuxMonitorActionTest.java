package com.sunfan.monitor.action.test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sunfan.monitor.controller.LinuxMonitorController;
import com.sunfan.monitor.entity.util.CpuInfoUtil;
import com.sunfan.monitor.entity.util.IOstatInfoUtil;
import com.sunfan.monitor.entity.util.MemoryInfoUtil;
import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;
import com.sunfan.monitor.service.LinuxService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class LinuxMonitorActionTest {
	

	@Autowired
	private LinuxMonitorController monitorAction;
	
	@Test
	public void testSysMonitor() {
		System.out.println(monitorAction.systemSummaryMonitor());
	}
	
//	@Test
//	public void testCpuMonitor() {
//		String res = monitorAction.cpuMonitor();
//		System.out.println(res);
//	}
//	@Test
//	public void testMemoryMonitor() {
//		String res = monitorAction.memoryMonitor();
//		System.out.println(res);
//		
//	}
//	@Test
//	public void testIOMonitor() {
//		String res = monitorAction.InputOutputMonitor();
//		System.out.println(res);
//	}
	
	@Configuration
	public static class BeanConfig{
		
		@Bean
		public LinuxMonitorController linuxMonitorController(){
			return new LinuxMonitorController();
		}
		
		@Bean
		public LinuxSessionHandle linuxSessionHandle(){
			return new LinuxSessionHandle();
		}
		
		@Bean
		public LinuxService linuxService(){
			return new LinuxService();
		}
		
		@Bean
		public LinuxConnectionPool linuxConnectionPool(){
			return new LinuxConnectionPool();
		}
		@Bean
		public CpuInfoUtil cpuInfoUtil(){
			return new CpuInfoUtil();
		}
		@Bean
		public MemoryInfoUtil memoryInfoUtil(){
			return new MemoryInfoUtil();
		}
		@Bean
		public IOstatInfoUtil iOstatInfoUtil(){
			return new IOstatInfoUtil();
		}
	}

}
