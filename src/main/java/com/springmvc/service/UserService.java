package com.springmvc.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.mapper.UserMapper;
import com.springmvc.entity.User;
import com.springmvc.rest.bean.ResponseBean;
import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestException;
import com.springmvc.rest.exceptions.RestExceptionStatus;
import static java.lang.String.*;

@Service
public class UserService {

	private static Logger logger = Logger.getLogger(UserService.class);
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
		ResponseBean bean = null;
		if (user == null) {
			if (logger.isEnabledFor(Level.WARN)) {
				logger.warn("the parameter submited is null");
			}
			return new ResponseBean(RestExceptionStatus.BAD_REQUEST.getStatus(), "the parameter submited is null");
		} else {

			try {
				if (user.selfCheck()) {
					if (userMapper.findByOpenNameAndPassword(user.getOpenname(), user.getPassword()) != null) {
						if (logger.isEnabledFor(Level.WARN)) {
							logger.warn(format("User[openname=%s] exitst", user.getOpenname()));
						}
						return new ResponseBean(RestExceptionStatus.DATA_EXIST.getStatus(),
								format("User[openname=%s] exitst", user.getOpenname()));
					} else {
						boolean result = userMapper.insertUser(user);
						if (result) {
							bean = new ResponseBean(status, msg);
							if (logger.isInfoEnabled()) {
								logger.info("insert successfully");
							}
						} else {
							bean = new ResponseBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
									RestExceptionStatus.OPERATION_FAILED.getMsg());
						}
					}
				}
			} catch (RestException e) {
				if (logger.isEnabledFor(Level.WARN)) {
					logger.warn(format("User selfCheck failed , Reason: %s", e.getMessage()), e);
				}
				return new ResponseBean(RestExceptionStatus.BAD_REQUEST.getStatus(), e.getMessage());
			} catch (Exception ee) {
				if (logger.isEnabledFor(Level.ERROR)) {
					logger.error(format("SqlError occurs, Reason: %s", ee.getMessage()), ee);
				}
				return new ResponseBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(), "SqlError occurs");
			}
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
		ResponseBean bean = null;
		if (user == null) {
			if (logger.isEnabledFor(Level.WARN)) {
				logger.warn("the parameter submited is null");
			}
			return new ResponseBean(RestExceptionStatus.BAD_REQUEST.getStatus(), "the parameter submited is null");
		}

		try {
			if (user.selfCheck()) {

				if (userMapper.findByUserId(user.getId()) == null) {
					if (logger.isEnabledFor(Level.WARN)) {
						logger.warn(format("User[id=%d] does not exist", user.getId()));
					}
					return new ResponseBean(RestExceptionStatus.DATA_EXIST.getStatus(),
							format("User[id=%s] exitst", user.getId()));
				} else {
					boolean result = userMapper.updateUser(user);
					
					if (result) {
						if (logger.isInfoEnabled()) {
							logger.info(format("User[id=%d]update successfully", user.getId()));
						}
						bean = new ResponseBean(status, msg);
					} else {
						bean = new ResponseBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
								RestExceptionStatus.OPERATION_FAILED.getMsg());
					}
					return bean;
				}

			}
		} catch (RestException e) {
			if (logger.isEnabledFor(Level.WARN)) {
				logger.warn(format("User selfCheck failed , Reason: %s", e.getMessage()), e);
			}
			return new ResponseBean(RestExceptionStatus.BAD_REQUEST.getStatus(), e.getMessage());
		} catch (Exception ee) {
			if (logger.isEnabledFor(Level.ERROR)) {
				logger.error(format("SqlError occurs, Reason: %s", ee.getMessage()), ee);
			}
			return new ResponseBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(), "SqlError occurs");
		}
		return bean;
	}

	/**
	 * 删除用户 delete user by id given
	 */
	public ResponseBean deleteUserById(int id) {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		ResponseBean bean = null;
		if (userMapper.findByUserId(id) == null) {
			if (logger.isEnabledFor(Level.WARN)) {
				logger.warn(format("User[id=%d] does not exist", id));
			}
			return new ResponseBean(RestExceptionStatus.DATA_NOT_EXIST.getStatus(),
					RestExceptionStatus.DATA_NOT_EXIST.getMsg());
		} else {
			try {
				userMapper.deleteUserById(id);
				bean = new ResponseBean(status, msg);
			} catch (Exception e) {
				if (logger.isEnabledFor(Level.ERROR)) {
					logger.error("Server Internal Error, Reason: " + e.getMessage(), e);
				}
				bean = new ResponseBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(),
						RestExceptionStatus.INTERNAL_ERROR.getMsg());
			}
		}
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
			
			if(StringUtils.isBlank(openName)){
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn("bad parameter ,Reason: openName can not be empty");
				}
				throw new RestException(RestExceptionStatus.BAD_REQ_PARAM.getStatus(), "openName can not be empty");
			} else if(StringUtils.isBlank(password)){
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn("bad parameter, Reason: password can not be empty");
				}
				throw new RestException(RestExceptionStatus.BAD_REQ_PARAM.getStatus(), "password can not be empty");
			} else {				
				return userMapper.findByOpenNameAndPassword(openName, password);
			}
		} catch (RestException e) {
			
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error(e.getMessage() , e);
			}
		} catch (Exception ee) {
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error("Internal Error", ee);
			}
		}
		return null;
	}

	/**
	 * list 全部用户 list all user
	 */
	public ResponseEntityBean list() {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		ResponseEntityBean bean = null;
		try {
			List<User> uses = userMapper.list();
			if (uses != null) {
				bean = new ResponseEntityBean(status, msg);
				bean.setEntity(uses);
			} else {
				bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
						RestExceptionStatus.OPERATION_FAILED.getMsg());
			}
		} catch (Exception e) {
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error(e);
			}
			bean = new ResponseEntityBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(), e.getMessage());
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

		if (org.apache.commons.lang.StringUtils.isBlank(openName)) {
			if (logger.isEnabledFor(Level.WARN)) {
				logger.warn("parameter openname can not be empty");
			}
			return new ResponseEntityBean(RestExceptionStatus.BAD_REQ_PARAM.getStatus(),
					RestExceptionStatus.BAD_REQ_PARAM.getMsg());
		}
		ResponseEntityBean bean = null;
		try {
			User user = userMapper.findByOpenName(openName);

			if (user != null) {
				bean = new ResponseEntityBean(status, msg);
				bean.setEntity(user);
			} else {
				bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
						RestExceptionStatus.OPERATION_FAILED.getMsg());
			}
		} catch (Exception e) {
			if (logger.isEnabledFor(Level.ERROR)) {
				logger.error("Internal Error", e);
			}
			
			bean = new ResponseEntityBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(), RestExceptionStatus.INTERNAL_ERROR.getMsg());
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
		ResponseEntityBean bean = null;
		try{
			User user = userMapper.findByUserId(id);
			if (user != null) {
				bean = new ResponseEntityBean(status, msg);
				bean.setEntity(user);
			} else {
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn(format("User[id=%d] dose not exist", id));
				}
				bean = new ResponseEntityBean(RestExceptionStatus.OPERATION_FAILED.getStatus(),
						RestExceptionStatus.OPERATION_FAILED.getMsg());
			}
		}catch(Exception e){
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error(e);
			}
			
			bean = new ResponseEntityBean(RestExceptionStatus.INTERNAL_ERROR.getStatus(), RestExceptionStatus.INTERNAL_ERROR.getMsg());
		}
		

		return bean;
	}

}
