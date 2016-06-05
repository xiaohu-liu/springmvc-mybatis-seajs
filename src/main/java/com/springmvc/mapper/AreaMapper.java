package com.springmvc.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.springmvc.entity.Area;

@Repository
public interface AreaMapper {

	public List<Area> listAll();
	
	public Area findById(int id);
	
	public List<Area> findByParentId(int pid);
	
}
