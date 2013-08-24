package com.chaos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chaos.dao.UserDao;
import com.chaos.jpa.User;

@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public void save(User user) {
		getHibernateTemplate().save(user);

	}

	@Override
	public void update(User user) {
		getHibernateTemplate().update(user);

	}

	@Override
	public void delete(User user) {
		getHibernateTemplate().delete(user);

	}

	@Override
	public User findByName(String name) {
		@SuppressWarnings("unchecked")
		List<User> result = getHibernateTemplate().find("from User where name=?", name);
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public User findByName(String projectCode, String name) {
		@SuppressWarnings("unchecked")
		List<User> result = getHibernateTemplate().find("from User where project_code =? and name=?", projectCode, name);
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}
}
