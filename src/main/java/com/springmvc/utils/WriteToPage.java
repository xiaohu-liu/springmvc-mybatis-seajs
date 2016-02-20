package com.springmvc.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class WriteToPage {

	private static final String ContentType = "application/json";
	protected static Logger log4j = Logger.getLogger(WriteToPage.class);

	public static void writeToPage(HttpServletResponse response,
			String resultData) {

		String message = StringUtils.EMPTY;
		PrintWriter out = null;
		try {
			message = resultData;
			response.setContentType(ContentType);
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
		} catch (Exception e) {
			message = "";
		} finally {
			log4j.info("response:" + message);
			out.print(message);
			out.flush();
			out.close();
		}
	}
}
