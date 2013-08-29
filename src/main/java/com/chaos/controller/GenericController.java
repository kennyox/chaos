package com.chaos.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.chaos.util.EnhancedMapper;
import com.chaos.vo.UserDetails;

public abstract class GenericController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected Logger errorLogger = LoggerFactory.getLogger("ExceptionLogger");
	
	@Autowired
	protected EnhancedMapper mapper;

	@ExceptionHandler(Exception.class)
	public String handleIOException(Exception ex, HttpServletRequest request) {
		return "error";
	}

	protected UserDetails getUser() {
		UserDetails user = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
			user = (UserDetails) auth.getPrincipal();
		}
		return user;
	}
}
