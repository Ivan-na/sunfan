package com.sunfan.monitor.service.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.sunfan.monitor.service.LinuxService;

public class LinuxServiceTest {
	LinuxService service;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMonitor() throws IOException {
        BeanFactory factory = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/springMVC-servlet.xml");  
        service = (LinuxService)factory.getBean("linuxService");
		String res = service.topMonitor("192.168.1.9", "root", "root");
		System.out.println(res);
	}

}
