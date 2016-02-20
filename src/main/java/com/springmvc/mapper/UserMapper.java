package com.springmvc.mapper;

import java.util.List;

import com.springmvc.entity.User;

public interface UserMapper {

	public boolean insertUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUserById(int id);
	
	public User findByUserId(int id);

	public List<User> list();
	
	public User findByOpenName(String openName);
}
