package com.smart.home.provider;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

import com.smart.home.model.Device;
import com.smart.home.model.User;

@Component
public class SessionFactoryProvider {
	@Bean
	@ApplicationScope
	public SessionFactory getInstance() {
		Configuration configuration = new Configuration();

		configuration.addAnnotatedClass(User.class);
		configuration.addAnnotatedClass(Device.class);

		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		return configuration.buildSessionFactory(registry);
	}
}
