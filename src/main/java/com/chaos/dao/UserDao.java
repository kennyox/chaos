package com.chaos.dao;

import com.chaos.jpa.User;

public interface UserDao {
	
	public void save(User user);

	public void update(User user);

	public void delete(User user);

	public User findByName(String name);
	
	public User findByName(String projectCode, String name);

}
