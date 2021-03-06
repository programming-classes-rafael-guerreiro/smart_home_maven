package com.smart.home.controller;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.PATCH;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smart.home.database.DeviceRepository;
import com.smart.home.dto.DeviceDTO;
import com.smart.home.model.Device;

@Controller
@RequestMapping("/devices")
public class DevicesController {

	@Autowired
	private DeviceRepository repository;

	@RequestMapping(method = GET)
	public String list() throws SQLException {
		List<Device> list = repository.list();

		System.out.println(list);

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
