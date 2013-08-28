package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.UserDao;
import com.chaos.jpa.User;

@Repository("userDao")
public class UserDaoImpl extends CommonDao implements UserDao {

	@Override
	public void save(User user) {
		getCurrentSession().save(user);

	}

	@Override
	public void update(User user) {
		getCurrentSession().update(user);

	}

	@Override
	public void delete(User user) {
		getCurrentSession().delete(user);

	}

	@Override
	public User findByName(String name) {
		@SuppressWarnings("unchecked")
		List<User> result = getCurrentSession()
				.createQuery("from User where name= :name")
				.setParameter("name", name).list();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
