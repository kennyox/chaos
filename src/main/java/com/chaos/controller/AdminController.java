package com.chaos.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.service.ProjectService;
import com.chaos.service.UserManagementService;
import com.chaos.vo.UserDetails;
import com.chaos.vo.UserVO;

@Controller
@RequestMapping("/admin")
public class AdminController extends GenericController {

	protected UserManagementService userService;
	protected ProjectService projectService;

	public UserManagementService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserManagementService userService) {
		this.userService = userService;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

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
			user = userService.findByName(userDetails.getProjectCode(), userDetails.getUsername());
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
}
