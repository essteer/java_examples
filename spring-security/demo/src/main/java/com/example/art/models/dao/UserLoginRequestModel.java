package com.example.art.models.dao;


public class UserLoginRequestModel {
	private String username, password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserLoginRequestModel [username=" + username + ", password=" + password + "]";
	}
	
}

