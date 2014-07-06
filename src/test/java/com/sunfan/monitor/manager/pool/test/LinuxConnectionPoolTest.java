package com.sunfan.monitor.manager.pool.test;

import java.io.IOException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.sunfan.monitor.manager.pool.LinuxConnectionPool;
import com.sunfan.monitor.platform.IConnectable;
import com.sunfan.monitor.platform.linux.LinuxConnection;
import com.sunfan.monitor.platform.linux.LinuxSessionHandle;
import com.trilead.ssh2.Connection;

public class LinuxConnectionPoolTest {
	LinuxConnectionPool pool;
	LinuxConnection lin1,lin2,lin3;
	Connection con1,con2;
	LinuxSessionHandle hanle ;
	@Before
	public void setUp() throws Exception {
	   pool = new LinuxConnectionPool();
	   lin1 = new LinuxConnection("192.168.1.9", "root", "root");
	   lin2 = new LinuxConnection("192.168.1.9", "sunfan", "abcd1234");
	   lin3 = new LinuxConnection("192.168.1.9", "sunfan", "abcd1234");
	}


	@Test
	public void testSaveObject() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);pool.saveObject(lin2);
		String key = pool.rewardConnectionKey(lin1);
		String key2 = pool.rewardConnectionKey(lin2);
		IConnectable p = pool.borrowObject(key);
		IConnectable p2 = pool.borrowObject(key);
		IConnectable p3 = pool.borrowObject(key2);
		IConnectable p4 = pool.borrowObject(key2);
		Assert.assertEquals(p2, p);
		Assert.assertNotSame(p, p3);
		Assert.assertEquals(p3, p4);
	}

	@Test
	public void testBorrowObjectString() {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);pool.saveObject(lin2);
		String key = pool.rewardConnectionKey(lin1);
		String key2 = pool.rewardConnectionKey(lin2);
		IConnectable p = pool.borrowObject(lin1);
		IConnectable p2 = pool.borrowObject(key);
		IConnectable p3 = pool.borrowObject(key2);
		IConnectable p4 = pool.borrowObject(lin2);
		Assert.assertEquals(p2, p);
		Assert.assertNotSame(p, p3);
		Assert.assertEquals(p3, p4);
	}

	@Test
	public void testBorrowObjectIConnectable() {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);pool.saveObject(lin2);
		String key = pool.rewardConnectionKey(lin1);
		String key2 = pool.rewardConnectionKey(lin2);
		IConnectable p = pool.borrowObject(lin1);
		IConnectable p2 = pool.borrowObject(key);
		IConnectable p3 = pool.borrowObject(key2);
		IConnectable p4 = pool.borrowObject(lin2);
		Assert.assertEquals(p2, p);
		Assert.assertNotSame(p, p3);
		Assert.assertEquals(p3, p4);
	}

	@Test
	public void testRemoveIConnectable() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);
		con1= lin1.getConnection();
		pool.remove(lin1);
		con1.connect();
	}

	@Test
	public void testRemoveString() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);
		con1= lin1.getConnection();
		pool.remove(pool.rewardConnectionKey(lin1));
		con1.connect();
		
	}

	@Test
	public void testClear() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		pool.saveObject(lin1);
		con1= lin1.getConnection();
		pool.clear();
		con1.connect();
	}

	@Test
	public void testRewardConnectionKey() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		System.out.println(pool.rewardConnectionKey(lin1));
	}

	@Test
	public void testIsExist() throws IOException {
		LinuxConnectionPool pool = new LinuxConnectionPool();
		System.out.println(pool.saveObject(lin1));
//		pool.clear();
		pool.remove(lin1);
//		pool.remove(pool.rewardConnectionKey(lin1));
		System.out.println(pool.saveObject(lin1));
	}

}
