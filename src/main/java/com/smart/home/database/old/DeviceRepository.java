package com.smart.home.database.old;

import java.util.List;

import com.smart.home.dto.DeviceDTO;
import com.smart.home.model.Device;

public interface DeviceRepository {
	List<Device> list();

	Device get(final int id);

	Device create(final DeviceDTO dto);

	Device update(final int id, final DeviceDTO dto);
}
