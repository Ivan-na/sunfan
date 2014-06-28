package com.sunfan.monitor.linux.test;

import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import com.sunfan.monitor.platform.linux.LinuxConnect;
import com.sunfan.monitor.platform.linux.LinuxHandle;
import com.trilead.ssh2.Connection;

public class LinuxHandleTest {
	LinuxConnect lin;
	Connection con;

	@Before
	public void setUp() throws Exception {
		lin = new LinuxConnect("192.168.1.9", "root", "root");
		con = lin.getConnection();
	}

	@Test
	public void testLinuxHandleForMutiThread() throws IOException {
		final LinuxHandle l = new LinuxHandle(con);
		final LinuxHandle l2 = new LinuxHandle(con);
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				String str = null;
				String str2 = null;
				try {
					str = l.executeCommand("pwd");
					str2 = l.executeCommand("pwd");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(str + "testLinuxHandleForMutiThread---------------");
				System.out.println(str2 + "testLinuxHandleForMutiThread----------");
			}
		});
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				String str3 = null;
				try {
					str3 = l2.executeCommand("pwd");
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println(str3 + "testLinuxHandleForMutiThread--------------");
			}
		});
		t.start();
		t3.start();

	}

	@Test
	public void testLinuxHandle() throws IOException {
		LinuxHandle l = new LinuxHandle(con);
		LinuxHandle l2 = new LinuxHandle(con);
		System.out.println(l.executeCommand("pwd") + "t1---------------");
		System.out.println(l.executeCommand("pwd") + "t2----------");
		System.out.println(l2.executeCommand("pwd") + "t3----------");

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
		lin = new LinuxConnect("192.168.1.9", "root", "root");
		LinuxConnect lin2 = new LinuxConnect("192.168.1.9", "root", "root");
		System.out.println(lin.getConnection());
		
	}
	
	
	

}
