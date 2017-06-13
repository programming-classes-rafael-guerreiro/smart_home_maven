package com.smart.home.model;

import org.joda.time.DateTime;
import org.joda.time.format.ISODateTimeFormat;

public class User {

	private final int id;
	private final String name;
	private final String email;
	private final DateTime lastSignIn;

	public User(final int id, final String name, String email, DateTime lastSignIn) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.lastSignIn = lastSignIn;
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

	public String getFormattedLastSignIn() {
		// return lastSignIn.toString(ISODateTimeFormat.dateTime());
		return lastSignIn.toString("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	}

	public DateTime getLastSignIn() {
		return lastSignIn;
	}
}
