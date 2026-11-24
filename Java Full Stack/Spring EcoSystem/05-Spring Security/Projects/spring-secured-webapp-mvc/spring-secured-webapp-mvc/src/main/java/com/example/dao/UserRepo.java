package com.example.dao;

public class UserRepo {
	
	AppUser[] users = {
			new AppUser("admin", "admin", "ADMIN"),
			new AppUser("user", "user", "USER")
	};

	public AppUser[] getUsers() {
		return users;
	}
	
}
