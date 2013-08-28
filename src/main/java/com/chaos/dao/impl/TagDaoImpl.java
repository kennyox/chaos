package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.TagDao;
import com.chaos.jpa.Tag;

@Repository("tagDao")
public class TagDaoImpl extends CommonDao implements TagDao {

	public void save(Tag tag) {
		getCurrentSession().save(tag);

	}

	public void update(Tag tag) {
		getCurrentSession().update(tag);

	}

	public void delete(Tag tag) {
		getCurrentSession().delete(tag);

	}

	@Override
	public List<Tag> getAllTag() {
		@SuppressWarnings("unchecked")
		List<Tag> result = getCurrentSession().getNamedQuery("Tag.findAll").list();
		return result;
	}

	@Override
	public Tag findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Tag> result = getCurrentSession().createQuery("from Tag where name=:name").setParameter("name",name).list();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
