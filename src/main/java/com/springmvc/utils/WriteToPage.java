package com.springmvc.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class WriteToPage {

	private static final String CONTENT_TYPE = "application/json";
	protected static Logger log4j = Logger.getLogger(WriteToPage.class);

	/**
	 * write the responseBody to the outputStream
	 * 
	 * @param response
	 *            HttpServletResponse Instance
	 * @param resultData
	 *            The responseBody given
	 */
	public static void writeToPage(HttpServletResponse response, String resultData) {

		String message = StringUtils.EMPTY;
		PrintWriter out = null;
		try {
			message = resultData;
			response.setContentType(CONTENT_TYPE);
			response.setHeader("Cache-Control", "no-cache");
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
		} catch (Exception e) {
			message = "";
			if (log4j.isEnabledFor(Level.ERROR)) {
				log4j.error(e);
			}
		} finally {
			if (log4j.isInfoEnabled()) {
				log4j.info("response:" + message);
			}
			if (out != null) {
				out.print(message);
				out.flush();
				out.close();
			}
		}
	}
}
