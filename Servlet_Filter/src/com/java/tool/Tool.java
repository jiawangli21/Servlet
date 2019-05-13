package com.java.tool;

public class Tool {

	
	 public static int countTime(Object str){
	    	int timeout=30*60;
	    	if("一小时".equals(str)){
	    		timeout =  60*60;
	    	}else if("一天".equals(str)){
	    		timeout =  60*60*24;
	    	}else if("一周".equals(str)){
	    		timeout =  60*60*24*7;
	    	}else if("一月".equals(str)){
	    		timeout =  60*60*24*7*30;
	    	}
	    	return timeout;
     }
}
