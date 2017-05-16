package com.smart.home.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.smart.home.dto.SignUpUserDTO;
import com.smart.home.dto.UserDTO;
import com.smart.home.model.User;

// DAO = Data Access Object
public class UserDAO {
	private final GenericDAO<User> dao = new GenericDAO<User>();
	private final GenericConverter<User> converter = new GenericConverter<User>() {
		@Override
		public User convert(ResultSet result) throws SQLException {
			final int id = result.getInt("user_id");
			final String name = result.getString("name");
			final String email = result.getString("email");

			return new User(id, name, email);
		}
	};

	public List<User> list() {
		return dao.list("select user_id, name, email from users", converter);
	}

	public User get(final int id) {
		return dao.get("select user_id, name, email from users where user_id = ?", converter, id);
	}

	public User signUp(final SignUpUserDTO dto) {
		if (dto == null || dto.isInvalid())
			return null;

		int id = dao.create("insert into users (name, email, password, password_salt) values (?, ?, ?, ?)",
				dto.getName(), dto.getEmail());
		return get(id);
	}

	public User update(final int id, final UserDTO dto) {
		dao.update("update users set name = ? where user_id = ?", id, dto.getName());
		return get(id);
	}
}
