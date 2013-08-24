package com.chaos.service;

import com.chaos.constant.Role;
import com.chaos.vo.UserVO;

public interface UserManagementService {

	public UserVO createUser(String projectCode, String name, String password, Role role);

	public UserVO findByName(String projectCode, String name);
	
}
