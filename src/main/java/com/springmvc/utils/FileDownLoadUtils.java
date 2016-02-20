package com.springmvc.utils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class FileDownLoadUtils {
	
	private static Logger logger = Logger.getLogger(FileDownLoadUtils.class);
	public static void downLoadFile(String fileName,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String filePath = request.getSession().getServletContext().getRealPath("upload/");
		File file = new File(filePath,fileName);
		if(file.exists()){
			byte[] data = FileUtils.readFileToByteArray(file);
			response.reset();
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");  
		    response.addHeader("Content-Length", "" + data.length);  
		    response.setContentType("application/octet-stream;charset=UTF-8");
		    OutputStream out = new BufferedOutputStream(response.getOutputStream());
		    out.write(data);
		    out.flush();
		    out.close();
		}else{
			logger.info("target file does not exist!please check it out!");
		}
	}
}
