package com.springmvc.rest.bean;

import java.io.Serializable;



/**
 * the response entity self-defined
 * @author Administrator
 *
 */
public class ResponseBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * the status of response
     */
    private Integer status;

    /**
     * the message of response
     */
    private String message;

    public ResponseBean() { }

    public ResponseBean(Integer status, String message) {
        this.status = status;
        this.message = message;
    }
    
    

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
