package com.example.dao;

public class AppUser {
	
	private String userName;
	private String password;
	private String role; // For DaoBased authentication, the role is stored as a String. In a real application, you might have a separate Role entity and a many-to-many relationship between users and roles.
	
	public AppUser(String name, String password, String role) {
		super();
		this.userName = name;
		this.password = password;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
