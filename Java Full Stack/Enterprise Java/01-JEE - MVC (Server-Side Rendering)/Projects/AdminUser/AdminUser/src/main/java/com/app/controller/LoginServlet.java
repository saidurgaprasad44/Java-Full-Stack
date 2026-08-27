package com.app.controller;

import com.app.model.User;
import com.app.service.LoginService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
 
public class LoginServlet extends HttpServlet {
	
	private LoginService loginService = new LoginService();
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        
    		User user = loginService.authenticateUser(req.getParameter("username"), req.getParameter("password"));
		if(user != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("user", user);
			
			resp.sendRedirect(req.getContextPath() + "/user");
		}
		else {
			req.setAttribute("errorMsg", "Invalid username or password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}   	
    }
    
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}
}