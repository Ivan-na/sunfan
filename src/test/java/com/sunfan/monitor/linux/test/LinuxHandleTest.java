package com.sunfan.monitor.linux.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.sunfan.monitor.entity.util.IOstatInfoUtil;
import com.sunfan.monitor.platform.linux.LinuxConnection;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;
import com.sunfan.monitor.service.LinuxService;
import com.trilead.ssh2.Connection;

public class LinuxHandleTest {
	LinuxConnection lin;
	Connection con;

	@Before
	public void setUp() throws Exception {
//		lin = new LinuxConnection("172.25.5.177", "rduser", "123");
//		lin = new LinuxConnection("172.25.5.175", "rduser", "123");
		lin = new LinuxConnection("10.6.142.21", "rduser", "123");
		con = lin.getConnection();
	}

	@Test
	public void testLinuxHandleForMutiThread() throws IOException {

	}

	@Test
	public void testLinuxHandle() throws IOException {
		LinuxSessionHandle l = new LinuxSessionHandle();
//		String res = l.executeCommand(con,"iostat -d -x 1 2");
//		IOstatInfoUtil ioUtil= new IOstatInfoUtil();
//		ioUtil.iostatResultTransferCpuObject(res);
		
//		String res = l.executeCommand(con,"grep -C 5 '高频延时命中IP' /opt/applog/laputa/daily.log");
		String res = l.executeCommand(con,"grep -c '高频延时命中IP' /opt/applog/laputa/daily.log");
		System.out.println(res);
	}

	@Test
	@Ignore
	public void testExecuteCommand() throws IOException {
	}

	@Test
	@Ignore
	public void testCloseSession() {
	}
	
	@Test
	public void case1() throws IOException{
		lin = new LinuxConnection("192.168.1.9", "root", "root");
		LinuxConnection lin2 = new LinuxConnection("192.168.1.9", "root", "root");
		System.out.println(lin.getConnection());
		
	}
	
	
	

}
