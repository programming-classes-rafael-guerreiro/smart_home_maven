package com.smart.home.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Application {
	private static final Properties PROPERTIES = new Properties();

	private static String token = null;
	private static int iterations = 0;

	static {
		try (InputStream stream = Application.class	.getClassLoader()
													.getResourceAsStream("development/application.properties")) {
			PROPERTIES.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Unable to read application.properties.", e);
		}
	}

	private Application() {
	}

	public static String getPasswordToken() {
		if (token != null)
			return token;

		return token = get("password.token");
	}

	public static int getPasswordIterations() {
		if (iterations > 0)
			return iterations;

		final String it = get("password.iteration");

		if (it == null)
			return iterations = 1;

		return iterations = Integer.parseInt(it);
	}

	private static String get(String key) {
		final String env = key.toUpperCase().replace('.', '_');
		final String value = System.getenv(env);
		if (value != null)
			return value;

		return PROPERTIES.getProperty(key);
	}
}
