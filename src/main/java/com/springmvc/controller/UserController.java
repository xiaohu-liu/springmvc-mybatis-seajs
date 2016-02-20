package com.springmvc.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.entity.User;
import com.springmvc.rest.bean.ResponseBean;
import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestExceptionStatus;
import com.springmvc.service.UserService;
import com.springmvc.utils.DateUtil;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = StringUtils.EMPTY, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntityBean findAll() {
		return userService.list();
	}

	@RequestMapping(value = StringUtils.EMPTY, method = RequestMethod.POST)
	@ResponseBody
	public ResponseBean insert(@RequestBody User user) {
		if (user != null) {
			
			if(StringUtils.isBlank(user.getOpenname())){
				return new ResponseBean(RestExceptionStatus.USERNAME_ERROR.getStatus(),RestExceptionStatus.USERNAME_ERROR.getMsg());
			} 
			
			if(StringUtils.isBlank(user.getPassword())){
				return new ResponseBean(RestExceptionStatus.PWD_ERROR.getStatus(), RestExceptionStatus.PWD_ERROR.getMsg());
			}
			
			
			user.setCreate_time(DateUtil.getCurrentMillSecond());
			user.setUpdate_time(DateUtil.getCurrentMillSecond());
			return userService.insertUser(user);
		}
		
		else 
			return new ResponseBean(RestExceptionStatus.BAD_REQ_PARAM.getStatus(), RestExceptionStatus.BAD_REQ_PARAM.getMsg());
		
	}

	@RequestMapping(value = StringUtils.EMPTY, method = RequestMethod.PUT)
	@ResponseBody
	public ResponseBean udpate(@RequestBody User user) {
		if (user != null) {
			user.setUpdate_time(DateUtil.getCurrentMillSecond());
		}
		return userService.updateUser(user);
	}

	@RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseBean delete(@PathVariable("userId") int userId) {
		return userService.deleteUserById(userId);
	}
}
