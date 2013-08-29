package com.chaos.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.service.UserManagementService;
import com.chaos.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminController extends GenericController {

	@Autowired
	protected UserManagementService	userService;

	@Autowired
	protected UserDetailsService	userDetailsService;

	@Autowired
	@Qualifier("authenticationManager")
	AuthenticationManager			authenticationManager;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView rootPage() {
		return getAdminPage();
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView rootPageIgnoredContent() {
		return getAdminPage();
	}

	private ModelAndView getAdminPage() {
		Map<String, Object> model = new HashMap<String, Object>();
		UserVO user = null;
		logger.debug("Received request to show admin page");
		UserDetails userDetails = getUser();
		if (userDetails != null) {
			user = userService.findByName(userDetails.getUsername());
		}

		model.put("user", user);
		return new ModelAndView("admin/admin", model);
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage() {
		logger.debug("Received request to show login page");
		return "admin/login";
	}

	@RequestMapping(value = "/loginFail", method = RequestMethod.GET)
	public String getLoginFailPage() {
		logger.debug("Received request to login fail");
		return "admin/login";
	}

	@RequestMapping(value = "/login/perform", method = RequestMethod.POST)
	@ResponseBody
	public UserDetails performLogin(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				userName, password);
		try {
			Authentication auth = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(auth);

			return userDetailsService.loadUserByUsername(auth.getName());
		} catch (BadCredentialsException ex) {
			return null;

		}
	}
	
	@RequestMapping(value = "/postLogin", method= RequestMethod.GET)
    public String createUser() {
        return "admin/postLogin";
    }
}
