package com.chaos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chaos.dao.TagDao;
import com.chaos.jpa.Tag;

@Repository
public class TagDaoImpl extends HibernateDaoSupport implements TagDao {

	public void save(Tag tag) {
		getHibernateTemplate().save(tag);

	}

	public void update(Tag tag) {
		getHibernateTemplate().update(tag);

	}

	public void delete(Tag tag) {
		getHibernateTemplate().delete(tag);

	}

	@Override
	public List<Tag> getAllTag(String projectCode) {
		@SuppressWarnings("unchecked")
		List<Tag> result = getHibernateTemplate().find("from Tag where projectCode = ? ", projectCode);
		return result;
	}

	@Override
	public Tag findByName(String projectCode, String code) {
		@SuppressWarnings("unchecked")
		List<Tag> result = getHibernateTemplate().find("from Tag where projectCode = ? and name=?", projectCode, code);
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
