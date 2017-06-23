package com.smart.home.application;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

public class PasswordEncryptor {

	public String encrypt(String password) {
		final String token = Application.getPasswordToken();

		String hex = Hashing.sha512().hashString(password, Charsets.UTF_8).toString();
		for (int i = 0; i < Application.getPasswordIterations(); i++) {
			hex = Hashing	.sha512()
							.hashString(new StringBuilder(hex).reverse().append(token).toString(), Charsets.UTF_8)
							.toString();
		}

		return hex;
	}

	public String salt(String password) {
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
