package com.springmvc.rest.exceptions;

import net.sf.json.JSONObject;


/**
 * @author Administrator
 *
 */
public class RestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer status;

	private String message;

	public RestException() {
	}

	public RestException(Integer status, String message) {
		this.status = status;
		this.message = message;
	}

	public Integer getStatus() {
		return status;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public static String exceptionToJson(RestException restException) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", restException.getStatus());
		jsonObject.put("message", restException.getMessage());
		return jsonObject.toString();
	}
	
	public static JSONObject exceptionToJSONObject(RestException e){
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", e.getStatus());
		jsonObject.put("message", e.getMessage());
		return jsonObject;
	}
}
