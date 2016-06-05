package com.springmvc.rest.bean;


/**
 * the response entity with response body
 * @author Administrator
 *
 */
public class ResponseEntityBean extends ResponseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * the body of response
	 */
	private Object entity;

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	public ResponseEntityBean(int status, String message) {
		super(status, message);
		entity = new DataEntity();
	}

	public ResponseEntityBean(int status, String message, Object entity) {
		super(status, message);
		this.entity = entity;
	}

	public ResponseEntityBean() {
		super();
	}

}
