package com.sunfan.monitor.entity.util;

import java.util.List;

public class EntityBaseUtil {
	
	/**get result of  reference by title
	 * 
	 * @param head   data of  reference title
	 * @param title   reference title
	 * @param infos  data of each  reference 
	 * @return  result of  reference by title ,if title is not matched ,return " "
	 */
	public String resolveValueByTagName(List<String> head,String[] infos,String title){
			if(head.indexOf(title)>0){
				return infos[head.indexOf(title)];
			}
		return "";
	}

}
