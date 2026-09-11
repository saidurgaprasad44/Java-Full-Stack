package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.User;

public class HomeServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if (session != null && session.getAttribute("user") != null) {
			User user = (User) session.getAttribute("user");
			req.setAttribute("role", user.getRole());
		} else {
			req.setAttribute("role", "GUEST");
		}
		
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}
}
