package com.springmvc.rest.exceptions;

/**

 */
public enum RestExceptionStatus {
    SUCCESS(200, "Success"),
    AUTH_FAILED(400, "Authentication failed"),
    BAD_REQUEST(401, "Bad request"),
    OPERATION_FAILED(1, "Operation failed"),
    NOT_FOUND(404, "404 Not found"),
    INTERNAL_ERROR(500, "Internal error"),

    DATA_EXIST(601,"The data submit already exists"),
    DATA_NOT_EXIST(602,"The data requested dose not exist"),
    
    
    BAD_REQ_PARAM(402,"Bad request - Invalid parameters"),
    ACCOUNT_FROZEN(404,"Account forbidden"),
    
    PWD_ERROR(4001,"Invalid password"),
    USERNAME_ERROR(4002,"Invalid userName"),
    REQUEST_METHOD_ERROR(4003,"Request Method Error"),
    CONFIG_ERROR(100010,"Configuration Error");
    
    /**
     * 异常状态码
     */
    private final int status;
    /**
     * 异常信息提示
     */
    private final String msg;

    private RestExceptionStatus(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() { return status; }

    public String getMsg() { return msg; }
}
