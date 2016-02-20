package com.springmvc.rest.bean;


public class ResponseEntityBean extends ResponseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
