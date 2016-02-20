package com.springmvc.rest.exceptions;


/**
 * @author Administrator
 *
 */
public enum RestRequestExceptionMsg {
    BAD_REQ("Bad Request"),
    BAD_REQ_PARAM("Bad Request - Invalid Parameters");
    private final String msg;

    private RestRequestExceptionMsg(String msg) { this.msg = msg; }

    public String getValue() { return msg; }
}
