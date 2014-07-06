package com.sunfan.monitor.linux.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.sunfan.monitor.platform.linux.LinuxConnection;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;
import com.trilead.ssh2.Connection;

public class LinuxHandleTest {
	LinuxConnection lin;
	Connection con;

	@Before
	public void setUp() throws Exception {
		lin = new LinuxConnection("192.168.1.9", "root", "root");
		con = lin.getConnection();
	}

	@Test
	public void testLinuxHandleForMutiThread() throws IOException {

	}

	@Test
	public void testLinuxHandle() throws IOException {
		LinuxSessionHandle l = new LinuxSessionHandle();
		LinuxSessionHandle l2 = new LinuxSessionHandle();
		System.out.println(l.executeCommand(con,"pwd") + "t1---------------");
		System.out.println(l.executeCommand(con,"pwd") + "t2----------");
		System.out.println(l2.executeCommand(con,"pwd") + "t3----------");

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
