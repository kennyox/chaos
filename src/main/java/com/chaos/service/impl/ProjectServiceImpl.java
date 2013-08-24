package com.chaos.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.jpa.Project;
import com.chaos.service.ProjectService;
import com.chaos.vo.ProjectVO;

@Service("projectService")
public class ProjectServiceImpl extends GenericService implements ProjectService {

	@Transactional
	@Override
	public void createProject(Project project) {
		projectDao.save(project);

	}

	@Override
	public ProjectVO findByCode(String code) {
		return mapper.map(projectDao.findByCode(code), ProjectVO.class);
	}

}
