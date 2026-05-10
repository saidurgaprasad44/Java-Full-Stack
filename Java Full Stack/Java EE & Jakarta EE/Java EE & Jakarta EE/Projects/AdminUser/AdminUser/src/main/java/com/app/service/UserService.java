package com.app.service;

import java.util.*;

import com.app.dao.UserDao;
import com.app.model.User;
 
public class UserService {
	
	private UserDao userDao = new UserDao();
 
    public User authenticate(String username, String password) {
    	
        if (username == null || password == null) {
            return null;
        }
        
        User user = userDao.findByCredentials(username, password);
 
        // business rule
        if (user != null) {
            return user;
        }
 
        return null;
    }
    
    public List<User> getAllUsers(){
    	
    	List<User> users= userDao.findAll();
    	if(users != null) {
    		return users;
    	}
    	
		return null;
    	
    }
    
    public User addNewUser(String username, String password, String role) {
    	
    	boolean added = userDao.addUser(username, password, role);
    	
    	if (!added) {
    		return null;
    	}
    	else {
    		User user = userDao.findByCredentials(username, password);
    		return user;
    	}
    	
    }
}