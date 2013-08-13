package com.hukuuu.restapi.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

public class CorsFilter extends OncePerRequestFilter{

	private static final String CORS_MAX_AGE_SECONDS = "30";

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		if("OPTIONS".equals(request.getMethod())) {
			response.setHeader("Access-Control-Allow-Method", request.getHeader("Access-Control-Request-Method"));
			response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
			response.setHeader("Access-Control-Max-Age", CORS_MAX_AGE_SECONDS);
		}
		
		filterChain.doFilter(request, response);
		
	}

}
