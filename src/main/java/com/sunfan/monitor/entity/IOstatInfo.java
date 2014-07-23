package com.sunfan.monitor.entity;

/**
 * IOstat info Device: rrqm/s wrqm/s r/s w/s rMB/s wMB/s avgrq-sz avgqu-sz await
 * r_await w_await svctm %util sda 0.05 0.85 4.24 0.97 0.10 0.16 100.92 0.18
 * 34.66 9.36 144.98 2.48 1.29
 * 
 * iostat -d -m (-x)
 * 
 * @author sunfan
 * 
 */
public class IOstatInfo {
	private String divice; // sda
	private String tps; // tps
	private String rrqm; // rrqm/s
	private String wrqm; // wrqm/s
	private String r; // r/s
	private String w; // w/s
	private String rmb; // rMB/s
	private String wmb; // wMB/s
	private String avgrq_sz; // avgrq-sz
	private String avgqu_sz; // avgqu-sz
	private String await; // await
	private String r_await; // r_await
	private String w_await; // w_await
	private String svctm; // svctm
	private String util; // %util
	private String blk_read_s; // Blk_read/s    kb   
	private String blk_wrtn_s; //Blk_wrtn/s     kb
	private String blk_read;//Blk_read          kb
	private String blk_wrtn; // Blk_wrtn        kb
	/**
	 * Indicate the number of transfers per second that were issued to the
	 * device. A transfer is an I/O request to the device. Multiple logical
	 * requests can be combined into a single I/O request to the device. A
	 * transfer is of inde‐ terminate size.
	 * 
	 * @return
	 */
	public String getDivice() {
		return divice;
	}

	public void setDivice(String divice) {
		this.divice = divice;
	}

	/**
	 * The number of read requests merged per second that were queued to the
	 * device.
	 * 
	 * @return
	 */
	public String getRrqm() {
		return rrqm;
	}

	public void setRrqm(String rrqm) {
		this.rrqm = rrqm;
	}

	/**
	 * The number of write requests merged per second that were queued to the
	 * device.
	 * 
	 * @return
	 */
	public String getWrqm() {
		return wrqm;
	}

	public void setWrqm(String wrqm) {
		this.wrqm = wrqm;
	}

	/**
	 * The number (after merges) of read requests completed per second for the
	 * device.
	 * 
	 * @return
	 */
	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	/**
	 * The number (after merges) of write requests completed per second for the
	 * device.
	 * 
	 * @return
	 */
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

	/**
	 * The average size (in sectors) of the requests that were issued to the
	 * device.
	 * 
	 * @return
	 */
	public String getAvgrq_sz() {
		return avgrq_sz;
	}

	public void setAvgrq_sz(String avgrq_sz) {
		this.avgrq_sz = avgrq_sz;
	}

	/**
	 * The average queue length of the requests that were issued to the device.
	 * 
	 * @return
	 */
	public String getAvgqu_sz() {
		return avgqu_sz;
	}

	public void setAvgqu_sz(String avgqu_sz) {
		this.avgqu_sz = avgqu_sz;
	}

	/**
	 * The average time (in milliseconds) for I/O requests issued to the device
	 * to be served. This includes the time spent by the requests in queue and
	 * the time spent servic‐ ing them.
	 * 
	 * @return
	 */
	public String getAwait() {
		return await;
	}

	public void setAwait(String await) {
		this.await = await;
	}

	/**
	 * The average time (in milliseconds) for read requests issued to the device
	 * to be served. This includes the time spent by the requests in queue and
	 * the time spent servic‐ ing them.
	 * 
	 * @return
	 */
	public String getR_await() {
		return r_await;
	}

	public void setR_await(String r_await) {
		this.r_await = r_await;
	}

	/**
	 * The average time (in milliseconds) for write requests issued to the
	 * device to be served. This includes the time spent by the requests in
	 * queue and the time spent servic‐ ing them.
	 * 
	 * @return
	 */
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

	/**
	 * Indicate the number of transfers per second that were issued to the
	 * device. A transfer is an I/O request to the device. Multiple logical
	 * requests can be combined into a single I/O request to the device. A
	 * transfer is of inde‐ terminate size.
	 * 
	 * @return
	 */
	public String getTps() {
		return tps;
	}

	public void setTps(String tps) {
		this.tps = tps;
	}

	public String getBlk_read_s() {
		return blk_read_s;
	}

	public void setBlk_read_s(String blk_read_s) {
		this.blk_read_s = blk_read_s;
	}

	public String getBlk_wrtn_s() {
		return blk_wrtn_s;
	}

	public void setBlk_wrtn_s(String blk_wrtn_s) {
		this.blk_wrtn_s = blk_wrtn_s;
	}

	public String getBlk_read() {
		return blk_read;
	}

	public void setBlk_read(String blk_read) {
		this.blk_read = blk_read;
	}

	public String getBlk_wrtn() {
		return blk_wrtn;
	}

	public void setBlk_wrtn(String blk_wrtn) {
		this.blk_wrtn = blk_wrtn;
	}

}
