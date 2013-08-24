package com.chaos.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chaos.dao.UserDao;
import com.chaos.jpa.User;
import com.chaos.jpa.UserRole;
import com.chaos.vo.UserDetails;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
	protected UserDao userDao;

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		UserDetails userDetails = null;
		User user = userDao.findByName(username);
		List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
		for (UserRole ur : user.getUserRoles()) {
			ga.add(new SimpleGrantedAuthority(ur.getRole()));
		}
		userDetails = new UserDetails(user.getName(), user.getPassword(), true, true, true, true, ga);
		userDetails.setProjectCode(user.getProject().getCode());
		return userDetails;
	}

}
