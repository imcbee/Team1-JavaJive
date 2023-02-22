package com.bah.mcc.day1.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bah.mcc.day1.jwt.JWTHelper;

@Component
@Order(1)
public class AuthFilter implements Filter {

	//fields for scope
	private String auth_scope = "com.bah.mcc.day1.auth.apis";
	private String api_scope = "com.bah.mcc.day1.data.apis";
	
	// initializing a JWTHelper
	private JWTHelper jwt_helper;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		// setting URI, JSON package for headers/bearer token
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String uri = req.getRequestURI();
		
		// check if URI contains proper route/endpoints
		if(!uri.startsWith("/api/customers") &&
				!uri.startsWith("/api/events") &&
				!uri.startsWith("/api/registrations")) {
			
			chain.doFilter(request, response);
			return;
			
		}else {
			// variable for authorization header?
			String authheader = req.getHeader("authorization");
			
			if(authheader != null && authheader.startsWith("Bearer") && authheader.length() > 7) {
				String jwt_token = authheader.substring(7, authheader.length());
				
				//use JWTHelper to verify the token
				if(jwt_helper.verifyToken(jwt_token)) {
					String scopes = jwt_helper.getScopes(jwt_token);
					
					if(scopes.contains(api_scope) || scopes.contains(auth_scope)) {
						
						chain.doFilter(request, response);
						return;
						
					}
				}
			}
		}
		
		// error statement
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");
		
	}
	
	
	

}
