package com.chaos.dao;

import java.util.List;

import com.chaos.jpa.Content;

public interface ContentDao {
	void save(Content content);

	void update(Content content);

	void delete(Content content);

	List<Content> getAllContent(String projectCode);
	
	Content findByCode(String projectCode, String code);

}