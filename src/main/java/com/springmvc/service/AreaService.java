package com.springmvc.service;

import java.util.ArrayList;
import java.util.List;

import javax.mail.UIDFolder;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.entity.Area;
import com.springmvc.mapper.AreaMapper;
import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestException;
import com.springmvc.rest.exceptions.RestExceptionStatus;

import static java.lang.String.format;

@Service
public class AreaService implements AreaMapper {

	
	private static Logger logger = Logger.getLogger(AreaService.class);
 	
	@Autowired
	private AreaMapper areaMapper;

	/**
	 * get the list of area
	 */
	@Override
	public List<Area> listAll() {
		return areaMapper.listAll();
	}
	
	/**
	 * query area by id given
	 */
	@Override
	public Area findById(int id) {
		return areaMapper.findById(id);
	}

	/**
	 * get the list of area by pid given
	 */
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
				if(logger.isInfoEnabled()){
					logger.info("list all Areas success, and total size is " + areas.size());
				}
				bean.setEntity(areas);
			} else {
				
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn("there is no any element of area type");
				}
				bean.setEntity(new ArrayList<Area>());
			}
			return bean;
		} catch (Exception e) {
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error("Internal Error occurs, Reason: ", e);
			}
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
				if(logger.isInfoEnabled()){
					logger.info(format("success find Area[id=%d]", id));
				}
				bean.setEntity(area);
			} else {
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn(format("Area[id=%d] does not exist", id));
				}
				bean.setMessage(RestExceptionStatus.DATA_NOT_EXIST.getMsg());
				bean.setStatus(RestExceptionStatus.DATA_NOT_EXIST.getStatus());
			}
			return bean;
		} catch (Exception e) {
			
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error("Internal Error occurs, Reason: ", e);
			}
			throw new RestException(
					RestExceptionStatus.OPERATION_FAILED.getStatus(),
					e.getMessage());
		}
	}

	/**
	 * @param pid
	 * 			the pid given
	 * @return
	 * @throws RestException
	 */
	public ResponseEntityBean findAreasByPid(int pid) throws RestException {
		int status = RestExceptionStatus.SUCCESS.getStatus();
		String msg = RestExceptionStatus.SUCCESS.getMsg();
		try {
			ResponseEntityBean bean = new ResponseEntityBean(status, msg);
			List<Area> areas = findByParentId(pid);
			if (areas != null) {
				if(logger.isInfoEnabled()){
					logger.info(format("success to find Area[pid=]", pid));
				}
				bean.setEntity(areas);
			} else {
				if(logger.isEnabledFor(Level.WARN)){
					logger.warn(format("Areas[pid=%d] does not exist", pid));
				}
				bean.setMessage(RestExceptionStatus.DATA_NOT_EXIST.getMsg());
				bean.setStatus(RestExceptionStatus.DATA_NOT_EXIST.getStatus());
				bean.setEntity(new ArrayList<Area>());
			}
			return bean;
		} catch (Exception e) {
			if(logger.isEnabledFor(Level.ERROR)){
				logger.error("Internal Error occurs, Reason: ", e);
			}
			throw new RestException(
					RestExceptionStatus.OPERATION_FAILED.getStatus(),
					e.getMessage());
		}
	}

}
