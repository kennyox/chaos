package com.chaos.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaos.dao.ContentDao;
import com.chaos.dao.ProjectDao;
import com.chaos.dao.TagDao;
import com.chaos.dao.UserDao;
import com.chaos.util.EnhancedMapper;

public abstract class GenericService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected UserDao userDao;
	protected ProjectDao projectDao;
	protected TagDao tagDao;
	protected ContentDao contentDao;
	protected EnhancedMapper mapper;

	@Autowired
	public void setMapper(EnhancedMapper mapper) {
		this.mapper = mapper;
	}

	@Autowired
	public void setContentDao(ContentDao contentDao) {
		this.contentDao = contentDao;
	}

	@Autowired
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	@Autowired
	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
