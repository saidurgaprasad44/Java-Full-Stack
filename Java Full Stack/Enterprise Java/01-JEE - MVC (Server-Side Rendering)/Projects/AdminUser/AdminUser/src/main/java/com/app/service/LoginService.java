package com.app.service;

import com.app.dao.UserDao;
import com.app.model.User;

public class LoginService {
	public User authenticateUser(String username, String password) {
		if (username == null || password == null) {
            return null;
        }
        UserDao userDao = new UserDao();
		return userDao .findByCredentials(username, password);
	}
}
