package com.chainsys.miniproject.commonutil;

public class ExceptionManager {
	public static String handleException(Exception err,String source , String message) {
		LogManager.logException(err,source, message);
		
		message+="Message: "+err.getMessage();
		String errorPage=HTMLHepler.getHTMLTemplate("ERROR",message);
		return errorPage;
	}

}

