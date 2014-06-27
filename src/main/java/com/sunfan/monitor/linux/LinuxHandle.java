package com.sunfan.monitor.linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

import com.trilead.ssh2.Session;
import com.trilead.ssh2.StreamGobbler;

public class LinuxHandle {
	Logger logger = (Logger) LoggerFactory.getLogger(LinuxHandle.class);
	Session session;
	LinuxHandle(Session session){
		this.session = session;
	}
	
	
	/**
	 * execute command and return result
	 * @param command
	 * @return String 
	 * @throws IOException 
	 */
	public String executeCommand(String command) throws IOException {
			session.execCommand(command);
			if(null!=session.getExitStatus()&&0!=session.getExitStatus()){
				logger.error("session exit status:"+session.getExitStatus()+"your command:"+command+" may be not support runable");
				}
		return this.read().toString();
	}
	
	private StringBuffer read() throws IOException{
		InputStream stdout = new StreamGobbler(session.getStdout());
		BufferedReader br = new BufferedReader(new InputStreamReader(stdout));
		String tempString = null;
		// readLine()每次调用都默认会读一行
		StringBuffer str = new StringBuffer();
		while ((tempString = br.readLine()) != null) {
			str.append(tempString+"\r\n");
		}
		br.close();
		a();
		return str;
	}
	
	public void a() throws IOException{
		try {
		b();
		System.out.println(1);
		} catch (Exception e) {
			throw new IOException("b excetion",e);
		}
	
	}
	
	public void b() throws IOException{
		throw new IOException();
	}
	
	public static void main(String[] args) throws IOException {
		try {
			LinuxConnect lin = new LinuxConnect("192.168.1.9", "root", "root");
			Session s = lin.getSesion();
			LinuxHandle l = new LinuxHandle(s);
			String str = l.executeCommand("ls");
			System.out.println(str);
		} catch (Exception e) {
			throw new IOException("YONGHUMINGCUOWU", e);
		}
		
	}

}
