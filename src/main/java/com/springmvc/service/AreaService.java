package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.Area;
import com.springmvc.mapper.AreaMapper;
import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestException;
import com.springmvc.rest.exceptions.RestExceptionStatus;

@Service
public class AreaService implements AreaMapper {

	@Autowired
	private AreaMapper areaMapper;

	@Override
	public List<Area> listAll() {
		return areaMapper.listAll();
	}

	@Override
	public Area findById(int id) {
		return areaMapper.findById(id);
	}

	@Override
	public List<Area> findByParentId(int pid) {
		return areaMapper.findByParentId(pid);
	}

	/**
	 * list all areas in the db
	 * 
	 * @return
	 */
	public ResponseEntityBean findAllAreas() throws RestException {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		try {
			List<Area> areas = listAll();
			ResponseEntityBean bean = new ResponseEntityBean(status, msg);
			if (areas != null) {
				bean.setEntity(areas);
			} else {
				bean.setEntity(new ArrayList<Area>());
			}
			return bean;
		} catch (Exception e) {
			throw new RestException(
					RestExceptionStatus.OPERATION_FAILED.getStatus(),
					e.getMessage());
		}

	}

	/**
	 * find Area by id given
	 * 
	 * @param id
	 * @return
	 * @throws RestException
	 */
	public ResponseEntityBean findAreaById(int id) throws RestException {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		try {
			ResponseEntityBean bean = new ResponseEntityBean(status, msg);
			Area area = findById(id);
			if (area != null) {
				bean.setEntity(area);
			}
			return bean;
		} catch (Exception e) {
			throw new RestException(
					RestExceptionStatus.OPERATION_FAILED.getStatus(),
					e.getMessage());
		}
	}

	public ResponseEntityBean findAreasByPid(int pid) throws RestException {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		try {
			ResponseEntityBean bean = new ResponseEntityBean(status, msg);
			List<Area> areas = findByParentId(pid);
			if (areas != null) {
				bean.setEntity(areas);
			} else {
				bean.setEntity(new ArrayList<Area>());
			}
			return bean;
		} catch (Exception e) {
			throw new RestException(
					RestExceptionStatus.OPERATION_FAILED.getStatus(),
					e.getMessage());
		}
	}

}
