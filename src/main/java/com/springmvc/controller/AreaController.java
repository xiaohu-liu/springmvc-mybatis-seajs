package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.rest.bean.ResponseEntityBean;
import com.springmvc.rest.exceptions.RestException;
import com.springmvc.service.AreaService;

@RequestMapping("area")
@Controller
public class AreaController {

	@Autowired
	private AreaService areaService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntityBean list() {
		try {
			return areaService.findAllAreas();
		} catch (RestException e) {
			return new ResponseEntityBean(e.getStatus(), e.getMessage());
		}
	}

	@RequestMapping(value = "getone/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntityBean findAreaById(@PathVariable("id") int id) {
		try {
			return areaService.findAreaById(id);
		} catch (RestException e) {
			return new ResponseEntityBean(e.getStatus(), e.getMessage());
		}
	}

	@RequestMapping(value = "listbypid/{pid}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntityBean listAreasByPid(@PathVariable("pid") int pid) {
		try {
			return areaService.findAreasByPid(pid);
		} catch (RestException e) {
			return new ResponseEntityBean(e.getStatus(), e.getMessage());
		}
	}

}
