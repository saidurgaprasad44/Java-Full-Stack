package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.User;
import com.app.service.UserService;

public class UserServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		User user = (User) req.getSession(false).getAttribute("user");
		
		UserService userService = new UserService();
		
		if (user.getRole().equals("admin")) {
    			List<User> users = userService.getAllUsers();
    			req.setAttribute("users", users);
    			req.setAttribute("name", user.getUsername());
    			req.getRequestDispatcher("WEB-INF/views/adminUser.jsp").forward(req, resp);
		}
    		else if(user.getRole().equals("basic")) {
    			req.setAttribute("username", user.getUsername());
    			req.getRequestDispatcher("WEB-INF/views/basicUser.jsp").forward(req, resp);
    		}
	}
}
