package com.smart.home.dto;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.smart.home.application.Application;

public class SignUpUserDTO {
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
		final String token = Application.getPasswordToken();

		String hex = Hashing.sha512().hashString(password, Charsets.UTF_8).toString();
		for (int i = 0; i < Application.getPasswordIterations(); i++) {
			hex = Hashing	.sha512()
							.hashString(new StringBuilder(hex).reverse().append(token).toString(), Charsets.UTF_8)
							.toString();
		}

		return hex;
	}

	public String getPasswordSalt() {
		final String token = Application.getPasswordToken();
		final String reversed = new StringBuilder(token).reverse().toString();

		String hex = Hashing.sha512().hashString(password, Charsets.UTF_8).toString();
		for (int i = 0; i < Application.getPasswordIterations(); i++) {
			StringBuilder builder = new StringBuilder(hex).reverse().append(i);
			builder.append(i % 2 == 0 ? token : reversed);

			hex = Hashing.sha512().hashString(builder.toString(), Charsets.UTF_8).toString();
		}

		return hex;
	}
}
