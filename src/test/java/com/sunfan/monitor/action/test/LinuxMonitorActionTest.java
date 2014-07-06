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

import com.sunfan.monitor.baseUtil.JsonMapper;
import com.sunfan.monitor.controller.LinuxMonitorController;
import com.sunfan.monitor.entity.MemoryInfo;
import com.sunfan.monitor.entity.Swap;
import com.sunfan.monitor.entity.util.CpuInfoUtil;
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
	
	@Test
	public void testCpuMonitor() {
		String res = monitorAction.cpuMonitor();
		System.out.println(res);
	}
	@Test
	public void testMemoryMonitor() {
		String res = monitorAction.memoryMonitor();
		System.out.println(res);
		
	}
	
	
	
	
	
	@Test 
	public void test() {
		String result = monitorAction.cpuMonitor();
		System.out.println(result);
		
		String[] strs= result.split("\r\n"); //remove header info
		List<String[]> resultList =new ArrayList<String[]>();
		for(String s:strs){
			if(s.contains(":")){
				resultList.add(s.split("\\s{1,}"));// spilt blackspace in many times
			}
		}
		
		List a =Arrays.asList(resultList.get(0));
//		System.out.println(a.indexOf("05:07:46 PM    0    7.18    0.03    1.78    1.92    0.00    0.08    0.00    0.00   89.00"));
		
		System.out.println(1);
	}
	
	
	
	
	
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
	}

}
