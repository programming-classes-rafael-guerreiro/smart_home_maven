package com.smart.home.database.old;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface GenericConverter<T> {
	T convert(ResultSet result) throws SQLException;
}
