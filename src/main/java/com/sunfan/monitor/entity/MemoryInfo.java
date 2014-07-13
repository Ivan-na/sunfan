package com.sunfan.monitor.entity;
/**
 * free -m
 * @author sunfan
 *
 */
public class MemoryInfo {
	private String total;
	private String used;
	private String free;
	private String shared;
	private String buffers;
	private String cached;
	private Swap swap;
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getUsed() {
		return used;
	}
	public void setUsed(String used) {
		this.used = used;
	}
	public String getFree() {
		return free;
	}
	public void setFree(String free) {
		this.free = free;
	}
	public String getShared() {
		return shared;
	}
	public void setShared(String shared) {
		this.shared = shared;
	}
	public String getBuffers() {
		return buffers;
	}
	public void setBuffers(String buffers) {
		this.buffers = buffers;
	}
	public String getCached() {
		return cached;
	}
	public void setCached(String cached) {
		this.cached = cached;
	}
	public Swap getSwap() {
		return swap;
	}
	public void setSwap(Swap swap) {
		this.swap = swap;
	}
	
}
