package com.smart.home.model;

public class User {

	private final int id;
	private final String name;
	private final String email;
	// private final Date lastSignIn; // NAO RECOMENDADO!!!

	public User(final int id, final String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
}
