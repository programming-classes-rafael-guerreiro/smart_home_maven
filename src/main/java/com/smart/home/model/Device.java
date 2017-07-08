package com.smart.home.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "devices")
public class Device {

	@Id
	@Column(name = "device_id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getUserId() {
		if (user == null)
			return return null;
		
		return userId;
	}
}
