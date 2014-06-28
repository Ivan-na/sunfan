package com.sunfan.monitor.platform;

import java.io.IOException;

public interface IMonitorable {
	public String executeCommand(String command) throws IOException ;
}
