package com.chaos.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chaos.dao.ContentDao;
import com.chaos.jpa.Content;

@Repository
public class ContentDaoImpl extends HibernateDaoSupport implements ContentDao {

	public void save(Content content) {
		getHibernateTemplate().save(content);

	}

	public void update(Content content) {
		getHibernateTemplate().update(content);

	}

	public void delete(Content content) {
		getHibernateTemplate().delete(content);

	}

	@Override
	public List<Content> getAllContent(String projectCode) {
		@SuppressWarnings("unchecked")
		List<Content> result = getHibernateTemplate().find("from Content where projectCode = ? ", projectCode);
		return result;
	}

	@Override
	public Content findByCode(String projectCode, String code) {
		@SuppressWarnings("unchecked")
		List<Content> result = getHibernateTemplate().find("from Content where projectCode = ? and code=?", projectCode, code);
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
