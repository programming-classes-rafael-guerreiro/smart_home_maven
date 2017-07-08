package com.smart.home.provider;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SessionProvider {

	@Autowired
	private SessionFactory factory;

	@Bean
	public Session getInstance() {
		return factory.openSession();
	}
}
