package com.sunfan.monitor.entity.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.sunfan.monitor.entity.IOstatInfo;
/**
 * 
 * @author sunfan
 *
 */
@Component
public class IOstatInfoUtil extends EntityBaseUtil{
	
	
	/**String iostatResult Transfer to list of IOstatInfo Object
	 * @param result List<IOstatInfo>
	 */
	public List<IOstatInfo> iostatResultTransferCpuObject(String result){
		List<String[]> contentArrayList = super.transferListofStringArray(result,"Device");
		return transfer(contentArrayList);
	}

	/**
	 * transfer List<IOstatInfo> 
	 * @param contentArrayList
	 * @return List<IOstatInfo> 
	 */
	public List<IOstatInfo> transfer(List<String[]> contentArrayList){
		List<IOstatInfo> IOstatInfoList = new ArrayList<IOstatInfo>();
		List<String> head =Arrays.asList(contentArrayList.get(0));
		contentArrayList.remove(0);
		for(String[] info:contentArrayList){
			IOstatInfo ioStatinfo = new IOstatInfo();
			ioStatinfo.setDivice(info[0]);
			ioStatinfo.setRrqm(resolveValueByTagName(head,info,"rrqm/s"));
			ioStatinfo.setTps(resolveValueByTagName(head,info,"tps"));
			ioStatinfo.setWrqm(resolveValueByTagName(head,info,"wrqm/s"));
			ioStatinfo.setR(resolveValueByTagName(head,info,"r/s"));
			ioStatinfo.setW(resolveValueByTagName(head,info,"w/s"));
			ioStatinfo.setRmb(resolveValueByTagName(head,info,"rMB/s"));;
			ioStatinfo.setWmb(resolveValueByTagName(head,info,"wMB/s"));
			ioStatinfo.setAvgrq_sz(resolveValueByTagName(head,info,"avgrq-sz"));
			ioStatinfo.setAvgqu_sz(resolveValueByTagName(head,info,"avgqu-sz"));
			ioStatinfo.setAwait(resolveValueByTagName(head,info,"await"));
			ioStatinfo.setR_await(resolveValueByTagName(head,info,"r_await"));
			ioStatinfo.setW_await(resolveValueByTagName(head,info,"w_await"));
			ioStatinfo.setSvctm(resolveValueByTagName(head,info,"svctm"));
			ioStatinfo.setUtil(resolveValueByTagName(head,info,"%util"));
			IOstatInfoList.add(ioStatinfo);
		}
		return IOstatInfoList;
	}
}
