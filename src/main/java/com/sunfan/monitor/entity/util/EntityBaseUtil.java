package com.sunfan.monitor.entity.util;

import java.util.ArrayList;
import java.util.List;

public class EntityBaseUtil {
	
	/**change String result to List<String> result by split "\r\n"
	 * remove the content above flag 
	 * to transfer List<String> ---> list<String[]> by .split("\\s{1,}")
	 * @param result
	 * @param flag
	 * @return
	 */
	public List<String[]> transferListofStringArray(String result,String flag){
		List<String> resList = this.transferList(result);
		List<String> contentList = this.removeResultHead(resList,flag);
		return this.transferArrayOfList(contentList);
	}
	
	/**
	 * change String result to List<String> result by split "\r\n"
	 * @param result
	 * @return List<String>
	 */
	public List<String> transferList(String result){
		String[] strs = result.split("\r\n");
		List<String> list = new ArrayList<String>();
		for(String s:strs){
			list.add(s);
		}
		return list;
	}
	
	/**remove the content above flag 
	 * 
	 * @return List<String>
	 */
	public List<String> removeResultHead(List<String> resultList,String flag){
		List<String> contentList = new ArrayList<String>();
		contentList.addAll(resultList);
		for(String res:resultList){
			if(res.contains(flag)){
				break;
			}
			contentList.remove(res);
		}
		return contentList;
	}
	
	
	/**to transfer List<String> ---> list<String[]> by .split("\\s{1,}")
	 * 
	 * @param contentList
	 * @return List<String[]>
	 */
	public List<String[]> transferArrayOfList(List<String> contentList){
		List<String[]> contentLists =new ArrayList<>();
		for(String content:contentList){
			contentLists.add(content.split("\\s{1,}"));
		}
		return contentLists;
	}
	
	/**get result of reference by title
	 * 
	 * @param head   data of  reference title
	 * @param title   reference title
	 * @param infos  data of each  reference 
	 * @return  String result of reference by title ,if title is not matched ,return " "
	 */
	public String resolveValueByTagName(List<String> head,String[] infos,String title){
			if(head.indexOf(title)>0){
				return infos[head.indexOf(title)];
			}
		return "";
	}

}
