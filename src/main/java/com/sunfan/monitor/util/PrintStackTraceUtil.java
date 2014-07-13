package com.sunfan.monitor.util;

import java.io.PrintWriter;
import java.io.StringWriter;
/**
 * 
 * @author sunfan
 *
 */
public class PrintStackTraceUtil{
	
    /**
     * this method use to solve record a exception stack information in dailylog
     * return  String type exception's stack information
     * 			
     * @param e exception 
     * @return
     */
	public static synchronized String printStackTrace(Exception e) {
		StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw, true));
        return sw.toString();
    }

}
