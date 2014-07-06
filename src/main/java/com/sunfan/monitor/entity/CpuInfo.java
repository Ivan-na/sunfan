package com.sunfan.monitor.entity;

public class CpuInfo {
	private String time;
	private String cpu; //user process rate of cpu
	private String usr;
	private String nice;
	private String sys;
	private String iowait;
	private String irq;
	private String soft;
	private String steal;
	private String guest;
	private String idle;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	public String getNice() {
		return nice;
	}
	public void setNice(String nice) {
		this.nice = nice;
	}
	public String getSys() {
		return sys;
	}
	public void setSys(String sys) {
		this.sys = sys;
	}
	public String getIowait() {
		return iowait;
	}
	public void setIowait(String iowait) {
		this.iowait = iowait;
	}
	public String getIrq() {
		return irq;
	}
	public void setIrq(String irq) {
		this.irq = irq;
	}
	public String getSoft() {
		return soft;
	}
	public void setSoft(String soft) {
		this.soft = soft;
	}
	public String getSteal() {
		return steal;
	}
	public void setSteal(String steal) {
		this.steal = steal;
	}
	public String getGuest() {
		return guest;
	}
	public void setGuest(String guest) {
		this.guest = guest;
	}
	public String getIdle() {
		return idle;
	}
	public void setIdle(String idle) {
		this.idle = idle;
	}

}
