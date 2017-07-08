package com.smart.home.database.old;

import java.sql.Connection;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope
public class MysqlConnectionProvider {

	@Bean
	public Connection getConnection() {
		System.out.println("Using MySQLConnectionProvider!");
		return ConnectionPool.getConnection();
	}
}
