package com.chaos.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 782377498248936871L;
	private Long userId;
	private String name;
	private String password;

	private List<UserRoleVO> userRoles = new ArrayList<UserRoleVO>();

	private ProjectVO project;

	public UserVO() {
		super();

	}

	public List<UserRoleVO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleVO> userRoles) {
		this.userRoles = userRoles;
	}

	public void addUserRoles(UserRoleVO userRole) {
		if (!getUserRoles().contains(userRole)) {
			getUserRoles().add(userRole);
		}
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ProjectVO getProject() {
		return project;
	}

	public void setProject(ProjectVO project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", name=" + name + ", password=" + password + ", userRoles=" + userRoles + ", project=" + project + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((userRoles == null) ? 0 : userRoles.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (userRoles == null) {
			if (other.userRoles != null)
				return false;
		} else if (!userRoles.equals(other.userRoles))
			return false;
		return true;
	}

}
