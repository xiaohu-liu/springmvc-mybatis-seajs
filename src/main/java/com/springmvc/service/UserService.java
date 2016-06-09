package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.UserMapper;
import com.springmvc.entity.User;
import com.springmvc.rest.bean.ResponseBean;
import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestExceptionStatus;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 添加用户
	 * 
	 * @param user
	 *            User to insert
	 * @return ResponseBean
	 * 
	 * 
	 */
	public ResponseBean insertUser(User user) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		boolean result = userMapper.insertUser(user);
		ResponseBean bean = null;
		if (result) {
			bean = new ResponseBean(status, msg);
		} else {
			bean = new ResponseBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
					RestExceptionStatus.OPERATION_FAILED.getMsg());
		}

		return bean;

	}

	/**
	 * 更新用户
	 * 
	 * @param user
	 *            User to update
	 * @return ResponseBean
	 */
	public ResponseBean updateUser(User user) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		boolean result = userMapper.updateUser(user);
		ResponseBean bean = null;
		if (result) {
			bean = new ResponseBean(status, msg);
		} else {
			bean = new ResponseBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
					RestExceptionStatus.OPERATION_FAILED.getMsg());
		}

		return bean;
	}

	/**
	 * 删除用户 delete user by id given
	 */
	public ResponseBean deleteUserById(int id) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		userMapper.deleteUserById(id);
		ResponseBean bean = null;
		bean = new ResponseBean(status, msg);

		return bean;
	}

	/**
	 * get user by openName given and password given
	 * 
	 * @param openName
	 * @param password
	 * @return
	 */
	public User findUserByOpenNameAndPwd(String openName, String password) {
		try {
			return userMapper.findByOpenNameAndPassword(openName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * list 全部用户 list all user
	 */
	public ResponseEntityBean list() {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		List<User> uses = userMapper.list();
		ResponseEntityBean bean = null;
		if (uses != null) {
			bean = new ResponseEntityBean(status, msg);
			bean.setEntity(uses);
		} else {
			bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
					RestExceptionStatus.OPERATION_FAILED.getMsg());
		}

		return bean;

	}

	/**
	 * 通过openName查找用户
	 * 
	 * @param openName
	 *            user's openName given
	 * @return ResponseEntityBean
	 */
	public ResponseEntityBean findByOpenName(String openName) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		User user = userMapper.findByOpenName(openName);
		ResponseEntityBean bean = null;
		if (user != null) {
			bean = new ResponseEntityBean(status, msg);
			bean.setEntity(user);
		} else {
			bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
					RestExceptionStatus.OPERATION_FAILED.getMsg());
		}

		return bean;
	}

	/**
	 * 通过用户id查找用户
	 * 
	 * @param id
	 *            the user's id given
	 * @return ResponseEntityBean
	 */
	public ResponseEntityBean findByUserId(int id) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		User user = userMapper.findByUserId(id);
		ResponseEntityBean bean = null;
		if (user != null) {
			bean = new ResponseEntityBean(status, msg);
			bean.setEntity(user);
		} else {
			bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
					RestExceptionStatus.OPERATION_FAILED.getMsg());
		}

		return bean;
	}

}
