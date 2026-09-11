package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.User;
import com.app.service.UserService;

public class ManageUsersServlet extends HttpServlet {
	
	UserService userService;
	
	@Override
	public void init() {
		userService = new UserService();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		List<User> users = userService.getAllUsers();
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/WEB-INF/views/manage-users.jsp").forward(req, resp);
		
	}

}
