package com.springmvc.utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * FileUploadUtils
 * 				used to upload the file local to application server
 * @author Administrator
 *
 */
public class FileUploadUtils {

	private static Logger logger = Logger.getLogger(FileUploadUtils.class);

	/**
	 * @param file
	 *            file to upload
	 * @param request
	 *            request instance
	 * @param response
	 *            response instance
	 * @throws IOException
	 */
	public static void uploadFile(MultipartFile file, HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String fileName = file.getName();
		String fileOriginalName = file.getOriginalFilename();
		long fileSize = file.getSize();
		logger.info(fileSize);
		logger.info(fileOriginalName);
		String uploadPath = request.getSession().getServletContext().getRealPath("/upload");
		FileUtils.copyInputStreamToFile(file.getInputStream(), new File(uploadPath, fileName));
	}
}
