package com.chaos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.constant.Role;
import com.chaos.dao.UserDao;
import com.chaos.jpa.User;
import com.chaos.service.UserManagementService;
import com.chaos.vo.UserVO;

@Service("userService")
public class UserManagementServiceImpl extends GenericService implements
		UserManagementService {

	UserDao	userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Transactional
	@Override
	public UserVO createUser(String userName, String password, Role role) {
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		userDao.save(user);		
		
		return mapper.map(user, UserVO.class);

	}

	@Override
	public UserVO findByName(String name) {
		return mapper.map(userDao.findByName(name), UserVO.class);
	}

}
