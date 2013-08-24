package com.chaos.dao;

import com.chaos.jpa.Project;

public interface ProjectDao {
	void save(Project project);

	void update(Project project);

	void delete(Project project);

	Project findByCode(String code);

}