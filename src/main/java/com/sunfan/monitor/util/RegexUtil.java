package com.sunfan.monitor.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtil {
	
	public List<String> matchRegex(String text,String regex){
		List<String> res= new ArrayList<String>();
		Pattern patern = Pattern.compile(regex);
		Matcher matcher = patern.matcher(text);
		while (matcher.find()) {
			res.add(matcher.group());
		}
		
		return res;
	}
	

	
}
