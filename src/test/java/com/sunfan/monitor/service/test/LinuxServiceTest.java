package com.sunfan.monitor.service.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sunfan.monitor.controller.LinuxMonitorController;
import com.sunfan.monitor.entity.util.CpuInfoUtil;
import com.sunfan.monitor.entity.util.IOstatInfoUtil;
import com.sunfan.monitor.entity.util.MemoryInfoUtil;
import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;
import com.sunfan.monitor.service.LinuxService;

public class LinuxServiceTest {
	LinuxService service ;
	@Test
	public void testMonitor() throws IOException {
		String res = service.executeCommand("172.25.5.175", "rduser", "123", "whoiam");
		System.out.println(res);
	}
	@Test
	public void testExecuteCommand() throws IOException{
		String res = service.cpuMonitor("192.168.1.9", "root", "root");
		System.out.println(res);
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
		@Bean
		public IOstatInfoUtil iOstatInfoUtil(){
			return new IOstatInfoUtil();
		}
	}

}
