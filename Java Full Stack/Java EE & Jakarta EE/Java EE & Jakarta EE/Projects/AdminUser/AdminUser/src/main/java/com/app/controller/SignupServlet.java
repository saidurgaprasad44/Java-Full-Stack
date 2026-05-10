package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class SignupServlet extends HttpServlet {
	
	private UserService userService = new UserService();
	 
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
 
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        
        User user = userService.addNewUser(username, password, role);
        
        if (user != null){
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        } else {
            req.setAttribute("errorMsg", "User is not added, try again");
            req.getRequestDispatcher("signup.jsp").forward(req, resp);
        }
    }
}
