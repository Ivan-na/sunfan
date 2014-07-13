package com.sunfan.monitor.entity;

/**
 * 
 * @author sunfan mpstat -P -ALL
 */
public class CpuInfo {
	private String time;
	private String cpu;
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

	/**
	 * Processor number. The keyword all indicates that statis‐tics are
	 * calculated as averages among all processors.
	 * 
	 * @return
	 */
	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getUsr() {
		return usr;
	}

	public void setUsr(String usr) {
		this.usr = usr;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getNice() {
		return nice;
	}

	public void setNice(String nice) {
		this.nice = nice;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 */
	public String getSys() {
		return sys;
	}

	public void setSys(String sys) {
		this.sys = sys;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getIowait() {
		return iowait;
	}

	public void setIowait(String iowait) {
		this.iowait = iowait;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getIrq() {
		return irq;
	}

	public void setIrq(String irq) {
		this.irq = irq;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getSoft() {
		return soft;
	}

	public void setSoft(String soft) {
		this.soft = soft;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getSteal() {
		return steal;
	}

	public void setSteal(String steal) {
		this.steal = steal;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	/**
	 * Show the percentage of CPU utilization that occurred while executing at
	 * the user level (application).
	 * 
	 * @return
	 */
	public String getIdle() {
		return idle;
	}

	public void setIdle(String idle) {
		this.idle = idle;
	}

}
