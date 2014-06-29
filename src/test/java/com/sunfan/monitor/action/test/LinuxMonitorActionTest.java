package com.sunfan.monitor.action.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sunfan.monitor.action.LinuxMonitorAction;
import com.sunfan.monitor.service.LinuxService;

public class LinuxMonitorActionTest {
	
	LinuxMonitorAction action = new LinuxMonitorAction();
	  BeanFactory factory = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/springMVC-servlet.xml");  
	@Before
	public void setUp() throws Exception {
      
	}

	@Test
	public void test() {
		action.setLinuxService((LinuxService)factory.getBean("linuxService"));
		String resd = action.TopAction();
		System.out.println(resd);
	}

}
