package com.chaos.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ProjectVO implements Serializable {

	private static final long serialVersionUID = 1301490003675341270L;
	private String code;
	private String name;

	private Set<UserVO> projectUsers = new HashSet<UserVO>();

	public ProjectVO() {
		super();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserVO> getProjectUsers() {
		return projectUsers;
	}

	public void setProjectUsers(Set<UserVO> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public void addProjectUsers(UserVO projectUser) {
		if (!this.projectUsers.contains(projectUser)) {
			projectUsers.add(projectUser);
			projectUser.setProject(this);
		}
	}

	@Override
	public String toString() {
		return "ProjectVO [projectCode=" + code + ", name=" + name + "]";
	}

}
