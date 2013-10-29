package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.TagDao;
import com.chaos.jpa.Tag;

@Repository("tagDao")
public class TagDaoImpl extends CommonDao implements TagDao {

	public void save(Tag tag) {
		getEm().persist(tag);

	}

	public void update(Tag tag) {
		getEm().merge(tag);

	}

	public void delete(Tag tag) {
		getEm().remove(tag);

	}

	@Override
	public List<Tag> getAllTag() {
		@SuppressWarnings("unchecked")
		List<Tag> result = getEm().createNamedQuery("Tag.findAll").getResultList();
		return result;
	}

	@Override
	public Tag findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Tag> result = getEm().createQuery("from Tag where name=:name").setParameter("name",name).getResultList();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
