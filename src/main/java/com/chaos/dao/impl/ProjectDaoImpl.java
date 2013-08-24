package com.chaos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chaos.dao.ProjectDao;
import com.chaos.jpa.Project;

@Repository
public class ProjectDaoImpl extends HibernateDaoSupport implements ProjectDao {

	@Override
	public void save(Project project) {
		getHibernateTemplate().save(project);

	}

	@Override
	public void update(Project project) {
		getHibernateTemplate().update(project);

	}

	@Override
	public void delete(Project project) {
		getHibernateTemplate().delete(project);

	}

	@Override
	public Project findByCode(String code) {
		@SuppressWarnings("unchecked")
		List<Project> result = getHibernateTemplate().find("from Project where code=?", code);
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
