package com.chaos.service;

import com.chaos.jpa.Project;
import com.chaos.vo.ProjectVO;

public interface ProjectService {

	public void createProject(Project project);

	public ProjectVO findByCode(String code);

}
