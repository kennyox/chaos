package com.chaos.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.vo.UserDetails;

@Controller
@RequestMapping("/")
public class DefaultController extends GenericController {

	/**
	 * Handles and retrieves the main page that everyone can see
	 * 
	 * @return the name of the ftl page
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView getCommonPage() {
		UserDetails userDetails = null;
		logger.debug("Received request to show common page");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && !(auth instanceof AnonymousAuthenticationToken)) {
			userDetails = (UserDetails) auth.getPrincipal();
		}

		return new ModelAndView("index", "userDetails", userDetails);
	}

}
