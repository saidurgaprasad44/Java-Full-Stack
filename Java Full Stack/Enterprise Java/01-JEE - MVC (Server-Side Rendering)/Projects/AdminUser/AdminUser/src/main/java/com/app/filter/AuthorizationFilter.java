package com.app.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.model.User;

public class AuthorizationFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
			
		HttpSession session = ((HttpServletRequest)request).getSession(false);
		User user = (User) session.getAttribute("user");
		
		// Role check: Only allow users whose role is explicitly "ADMIN"
		if (user != null && user.getRole() != null && "ADMIN".equalsIgnoreCase(user.getRole().trim())) {
			// Authorized! Move forward to the Admin Servlet
            chain.doFilter(request, response);
		} 
		else{
			// Authenticated but not allowed. Return 403 Forbidden
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Access Denied: Admin role required.");
		}

	}

}
