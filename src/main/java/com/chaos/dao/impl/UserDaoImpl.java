package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.UserDao;
import com.chaos.jpa.User;

@Repository("userDao")
public class UserDaoImpl extends CommonDao implements UserDao {

	@Override
	public void save(User user) {
		getEm().persist(user);

	}

	@Override
	public void update(User user) {
		getEm().merge(user);

	}

	@Override
	public void delete(User user) {
		getEm().remove(user);

	}

	@Override
	public User findByName(String name) {
		@SuppressWarnings("unchecked")
		List<User> result = getEm()
				.createQuery("from User where userName= :name")
				.setParameter("name", name).getResultList();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
