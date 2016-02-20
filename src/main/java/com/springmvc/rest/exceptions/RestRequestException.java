package com.springmvc.rest.exceptions;

/**
 * @author Administrator
 * 
 */
public class RestRequestException extends RestException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RestRequestException() {
		super(RestExceptionStatus.BAD_REQUEST.getStatus(),
				RestExceptionStatus.BAD_REQUEST.getMsg());
	}

	public RestRequestException(String message) {
		super(RestExceptionStatus.BAD_REQUEST.getStatus(), message);
	}
}
