package com.chaos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.constant.Role;
import com.chaos.jpa.User;
import com.chaos.service.UserManagementService;
import com.chaos.vo.UserVO;

@Controller
@RequestMapping("/admin/user")
public class UserManagementController extends GenericController {

	protected UserManagementService userService;

	public UserManagementService getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserManagementService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView rootPage() {
		return rootPageContent();
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView rootPageIgnoredContent() {
		return rootPageContent();
	}

	private ModelAndView rootPageContent() {
		return new ModelAndView("admin/user/user");
	}

	@RequestMapping(value = "/create/admin/{projectCode}/{userName}/{password}", method = RequestMethod.GET)
	public @ResponseBody UserVO createSiteAdminUser(@PathVariable String projectCode, @PathVariable String userName, @PathVariable String password) {
		UserVO user = userService.createUser(projectCode, userName, password, Role.ADMIN);
		return  user;
	}
	
	@RequestMapping(value = "/create/admin", method = RequestMethod.POST)
	public @ResponseBody UserVO createSiteAdminUserByPost(@RequestParam("projectCode") String projectCode, @RequestParam("userName") String userName,@RequestParam("password") String password) {
		
		UserVO user = userService.createUser(projectCode, userName, password, Role.ADMIN);
		return  user;
	}


	@RequestMapping(value = "/create/{userName}/{password}", method = RequestMethod.GET)
	public @ResponseBody User createUser(@PathVariable String userName, @PathVariable String password) {
		User user = new User();
		/*
		 * user.setName(userName); user.setPassword(password);
		 * userService.createUser(user, Role.USER);
		 */
		return  user;
	}

}
