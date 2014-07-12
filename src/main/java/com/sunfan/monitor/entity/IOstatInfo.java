package com.sunfan.monitor.entity;

/**
 * IOstat info
 * Device:         rrqm/s   wrqm/s     r/s     w/s    rMB/s    wMB/s avgrq-sz avgqu-sz   await r_await w_await  svctm  %util
    sda              0.05     0.85    4.24    0.97     0.10     0.16   100.92     0.18   34.66    9.36  144.98   2.48   1.29
 * 
 * @author root
 *
 */
public class IOstatInfo {
	private String divice;       // sda
	private String tps;       // tps
	private String rrqm;         // rrqm/s
	private String wrqm;          // wrqm/s
	private String r;            // r/s 
	private String w;            // w/s
	private String rmb;          // rMB/s
	private String wmb;          // wMB/s 
	private String avgrq_sz;     // avgrq-sz
	private String avgqu_sz;     // avgqu-sz
	private String await;        // await
	private String r_await;      // r_await
	private String w_await;      // w_await
	private String svctm;        // svctm
	private String util;         // %util
	public String getDivice() {
		return divice;
	}
	public void setDivice(String divice) {
		this.divice = divice;
	}
	public String getRrqm() {
		return rrqm;
	}
	public void setRrqm(String rrqm) {
		this.rrqm = rrqm;
	}
	public String getWrqm() {
		return wrqm;
	}
	public void setWrqm(String wrqm) {
		this.wrqm = wrqm;
	}
	public String getR() {
		return r;
	}
	public void setR(String r) {
		this.r = r;
	}
	public String getW() {
		return w;
	}
	public void setW(String w) {
		this.w = w;
	}
	public String getRmb() {
		return rmb;
	}
	public void setRmb(String rmb) {
		this.rmb = rmb;
	}
	public String getWmb() {
		return wmb;
	}
	public void setWmb(String wmb) {
		this.wmb = wmb;
	}
	public String getAvgrq_sz() {
		return avgrq_sz;
	}
	public void setAvgrq_sz(String avgrq_sz) {
		this.avgrq_sz = avgrq_sz;
	}
	public String getAvgqu_sz() {
		return avgqu_sz;
	}
	public void setAvgqu_sz(String avgqu_sz) {
		this.avgqu_sz = avgqu_sz;
	}
	public String getAwait() {
		return await;
	}
	public void setAwait(String await) {
		this.await = await;
	}
	public String getR_await() {
		return r_await;
	}
	public void setR_await(String r_await) {
		this.r_await = r_await;
	}
	public String getW_await() {
		return w_await;
	}
	public void setW_await(String w_await) {
		this.w_await = w_await;
	}
	public String getSvctm() {
		return svctm;
	}
	public void setSvctm(String svctm) {
		this.svctm = svctm;
	}
	public String getUtil() {
		return util;
	}
	public void setUtil(String util) {
		this.util = util;
	}
	public String getTps() {
		return tps;
	}
	public void setTps(String tps) {
		this.tps = tps;
	}
	
	
}
