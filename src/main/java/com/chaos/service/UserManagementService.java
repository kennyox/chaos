package com.chaos.service;

import com.chaos.constant.Role;
import com.chaos.vo.UserVO;

public interface UserManagementService {

	public UserVO createUser(String userName, String password, Role role);

	public UserVO findByName(String userName);
	
}
