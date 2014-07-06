package com.sunfan.monitor.service.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sunfan.monitor.service.LinuxService;

public class LinuxServiceTest {
	BeanFactory factory = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/springMVC-servlet.xml");  
	LinuxService service = (LinuxService)factory.getBean("linuxService");

	@Test
	public void testMonitor() throws IOException {
		String res = service.topMonitor("192.168.1.9", "root", "root");
		System.out.println(res);
	}
	@Test
	public void testExecuteCommand() throws IOException{
		String res = service.cpuMonitor("192.168.1.9", "root", "root");
		System.out.println(res);
	}

}
