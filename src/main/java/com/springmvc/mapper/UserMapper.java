package com.springmvc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.User;

@Repository
public interface UserMapper {

	public boolean insertUser(User user);

	public boolean updateUser(User user);

	public boolean deleteUserById(int id);
	
	public User findByUserId(int id);

	public List<User> list();
	
	public User findByOpenName(String openName);
}
