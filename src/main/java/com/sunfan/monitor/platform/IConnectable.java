package com.sunfan.monitor.platform;

import java.io.Closeable;
import java.io.IOException;

import com.trilead.ssh2.Connection;

public interface IConnectable extends Closeable{
	
	public Connection getConnection();
	public String getPassword();
	public String getUrl();
	public String getUser();
}
