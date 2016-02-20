package com.springmvc.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {
	
	private static Logger logger = Logger.getLogger(FileUploadUtils.class);
	public static void uploadFile(MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException{
		String fileName = file.getName();
		String fileOriginalName = file.getOriginalFilename();
		long fileSize = file.getSize();
		logger.info(fileSize);
		logger.info(fileOriginalName);
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadPath,fileName));
	}
}
