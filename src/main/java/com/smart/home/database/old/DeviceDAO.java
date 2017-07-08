package com.smart.home.database.old;

import java.beans.ConstructorProperties;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;

import com.smart.home.dto.DeviceDTO;
import com.smart.home.model.Device;

@Component
public class DeviceDAO implements DeviceRepository {
	private final GenericDAO<Device> dao;
	private final GenericConverter<Device> converter = new GenericConverter<Device>() {
		@Override
		public Device convert(ResultSet result) throws SQLException {
			final int id = result.getInt("device_id");
			final String name = result.getString("name");
			final int userId = result.getInt("user_id");

			return new Device(id, name, userId);
		}
	};

	@ConstructorProperties({ "connection" })
	public DeviceDAO(Connection connection) {
		dao = new GenericDAO<Device>(connection);
	}

	public List<Device> list() {
		try {
			return dao.list("select device_id, name, user_id from devices", converter);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Device get(final int id) {
		try {
			return dao.get("select device_id, name, user_id from devices where device_id = ?", converter, id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Device create(final DeviceDTO dto) {
		try {
			int id = dao.create("insert into devices (name, user_id) values (?, ?)", dto.getName(), dto.getUserId());
			return get(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Device update(final int id, final DeviceDTO dto) {
		try {
			dao.update("update devices set name = ?, user_id = ? where device_id = ?", id, dto.getName(),
					dto.getUserId());
			return get(id);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
