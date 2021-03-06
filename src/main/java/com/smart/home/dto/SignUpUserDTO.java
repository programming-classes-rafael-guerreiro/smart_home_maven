package com.smart.home.dto;

import com.smart.home.application.PasswordEncryptor;

public class SignUpUserDTO {
	private final PasswordEncryptor encryptor = new PasswordEncryptor();

	private final String name;
	private final String email;
	private final String password;
	private final String passwordConfirmation;

	public SignUpUserDTO(String name, String email, String password, String passwordConfirmation) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.passwordConfirmation = passwordConfirmation;
	}

	public boolean isInvalid() {
		if (isFilled(name) && isFilled(email) && isFilled(password))
			return !password.equals(passwordConfirmation);

		return true;
	}

	private boolean isFilled(String text) {
		return text != null && !text.trim().isEmpty();
	}

	public String getName() {
		return name;
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
