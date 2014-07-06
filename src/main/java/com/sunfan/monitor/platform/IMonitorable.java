package com.sunfan.monitor.platform;

import java.io.IOException;

import com.trilead.ssh2.Connection;

public interface IMonitorable {
	public String executeCommand(Connection conn,String command) throws IOException ;
}
