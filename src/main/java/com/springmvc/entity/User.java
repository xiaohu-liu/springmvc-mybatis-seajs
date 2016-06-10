package com.springmvc.entity;

import java.io.Serializable;

import org.apache.commons.lang.StringUtils;

import com.springmvc.rest.exceptions.RestException;
import com.springmvc.rest.exceptions.RestExceptionStatus;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private int id;
	/**
	 * 登录名
	 */
	private String openname;
	/**
	 * 登录方式
	 */
	private String type;
	/**
	 * 登录密码
	 */
	private String password;
	/**
	 * 用户状态
	 */
	private int status;
	/**
	 * 用户信息更新时间
	 */
	private long update_time;
	/**
	 * 用户注册时间
	 */
	private long create_time;

	/**
	 * 删除标志
	 */
	private int del;

	public String getOpenname() {
		return openname;
	}

	public void setOpenname(String openname) {
		this.openname = openname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}

	public long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public User() {

	}

	public User(int id, String openname, String type, String password, int status, long update_time, long create_time,
			int del) {
		this.id = id;
		this.openname = openname;
		this.type = type;
		this.password = password;
		this.status = status;
		this.update_time = update_time;
		this.create_time = create_time;
		this.del = del;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", openname=" + openname + ", type=" + type + ", password=" + password + ", status="
				+ status + ", update_time=" + update_time + ", create_time=" + create_time + ", del=" + del + "]";
	}

	/**
	 * check the validation about the parameter
	 * 
	 * @return
	 * @throws RestException
	 */
	public boolean selfCheck() throws RestException {
		if (StringUtils.isBlank(openname)) {
			throw new RestException(RestExceptionStatus.BAD_REQUEST.getStatus(), "openname can not be empty");
		} else if (StringUtils.isBlank(password)) {
			throw new RestException(RestExceptionStatus.BAD_REQUEST.getStatus(), "password can not be empty");
		}
		return true;
	}

}
