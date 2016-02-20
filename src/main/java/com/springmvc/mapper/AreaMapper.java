package com.springmvc.mapper;

import java.util.List;

import com.springmvc.entity.Area;

public interface AreaMapper {

	public List<Area> listAll();
	
	public Area findById(int id);
	
	public List<Area> findByParentId(int pid);
	
}
