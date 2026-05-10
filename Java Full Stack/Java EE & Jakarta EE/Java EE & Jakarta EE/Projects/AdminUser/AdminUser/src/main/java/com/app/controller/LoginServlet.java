package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;
 
public class LoginServlet extends HttpServlet {
	
	private UserService userService = new UserService();
 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        
        User user = userService.authenticate(username, password);
        List<User> users = userService.getAllUsers();
        
        if (user != null){
        	if (user.getRole().equals("admin")) {
        		req.setAttribute("users", users);
        		req.setAttribute("name", user.getUsername());
        		req.getRequestDispatcher("admin.jsp").forward(req, resp);
        	}
        	else if(user.getRole().equals("basic")) {
        		req.setAttribute("username", user.getUsername());
        		req.getRequestDispatcher("basicUser.jsp").forward(req, resp);
        	}
        } else {
            req.setAttribute("errorMsg", "Invalid username or password");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}