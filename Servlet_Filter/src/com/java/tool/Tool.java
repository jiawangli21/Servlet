package com.java.tool;

public class Tool {

	
	 public static int countTime(Object str){
	    	int timeout=30*60;
	    	if("һСʱ".equals(str)){
	    		timeout =  60*60;
	    	}else if("һ��".equals(str)){
	    		timeout =  60*60*24;
	    	}else if("һ��".equals(str)){
	    		timeout =  60*60*24*7;
	    	}else if("һ��".equals(str)){
	    		timeout =  60*60*24*7*30;
	    	}
	    	return timeout;
     }
}
