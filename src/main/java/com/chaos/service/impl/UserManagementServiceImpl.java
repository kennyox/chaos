package com.chaos.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.constant.Role;
import com.chaos.jpa.Project;
import com.chaos.jpa.User;
import com.chaos.service.UserManagementService;
import com.chaos.vo.UserVO;

@Service("userService")
public class UserManagementServiceImpl extends GenericService implements UserManagementService {

	@Transactional
	@Override
	public UserVO createUser(String projectCode, String name, String password, Role role) {
		Project project = projectDao.findByCode(projectCode);
		if (project != null) {
			User user = new User();
			user.setName(name);
			user.setPassword(password);
			userDao.save(user);
			project.addProjectUsers(user);
			projectDao.update(project);
			return mapper.map(user, UserVO.class);
		}
		return null;
	}

	@Override
	public UserVO findByName(String projectCode, String name) {
		return mapper.map(userDao.findByName(projectCode,name),UserVO.class);
	}

}
