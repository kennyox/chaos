package com.chaos.dao;

import java.util.List;

import com.chaos.jpa.Tag;

public interface TagDao {
	void save(Tag tag);

	void update(Tag tag);

	void delete(Tag tag);

	List<Tag> getAllTag();
	
	Tag findByName(String name);

}