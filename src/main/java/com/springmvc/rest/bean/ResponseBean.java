package com.springmvc.rest.bean;

import java.io.Serializable;

/**
 * Created by Huang, Hua on 2014/12/10.
 */

public class ResponseBean implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    private Integer status;

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
