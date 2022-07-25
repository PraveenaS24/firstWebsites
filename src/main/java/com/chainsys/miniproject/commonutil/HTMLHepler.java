package com.chainsys.miniproject.commonutil;

public class HTMLHepler {
	public static String getHTMLTemplate(String title, String body) {
		String htmlOutput = "<html><head><title>" + title + "</title></head><body>";
		htmlOutput += "<div> " + body + "</div></body></html>";

		return htmlOutput;
	}

}
