package com.smart.home.database;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smart.home.model.Device;

@Component
public class DeviceRepository {

	@Autowired
	private Session session;

	@SuppressWarnings("unchecked")
	public List<Device> list() {
		return session.createCriteria(Device.class).list();
	}
}
