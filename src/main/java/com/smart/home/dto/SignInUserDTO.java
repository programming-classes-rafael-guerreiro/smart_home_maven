package com.smart.home.dto;

import com.smart.home.application.PasswordEncryptor;

public class SignInUserDTO {
	private final PasswordEncryptor encryptor = new PasswordEncryptor();

	private final String email;
	private final String password;

	public SignInUserDTO(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public boolean isInvalid() {
		return !isFilled(email) || !isFilled(password);
	}

	private boolean isFilled(String text) {
		return text != null && !text.trim().isEmpty();
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return encryptor.encrypt(password);
	}

	public String getPasswordSalt() {
		return encryptor.salt(password);
	}
}
