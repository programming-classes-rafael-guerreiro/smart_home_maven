package com.smart.home.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.home.dto.DeviceDTO;

@Controller
@RequestMapping("/devices")
public class DevicesController {
	
	public DevicesController() {
	}
	
	@RequestMapping(method = GET)
	public String list() {
		return "devices/index";
	}

	@RequestMapping(method = GET, path = "/{id}")
	public void get(@PathVariable Long id) {
	}

	@RequestMapping(method = POST)
	public void create(DeviceDTO dto) {
	}

	@RequestMapping(method = { PUT, PATCH }, path = "/{id}")
	public void update(@PathVariable Long id, DeviceDTO dto) {
	}

	@RequestMapping(method = DELETE, path = "/{id}")
	public void delete(@PathVariable Long id) {
	}
}
