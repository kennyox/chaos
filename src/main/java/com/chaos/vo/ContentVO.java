package com.chaos.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ContentVO implements Serializable {

	private static final long serialVersionUID = 4847136576456184982L;
	private Long contentId;
	private String code;
	private String name;
	private String description;
	private String projectCode;

	private Set<String> taggedByTags = new HashSet<String>();

	public Long getContentId() {
		return contentId;
	}

	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<String> getTaggedByTags() {
		return taggedByTags;
	}

	public void setTaggedByTags(Set<String> taggedByTagsName) {
		this.taggedByTags = taggedByTagsName;
	}

	public void addTaggedByTag(String taggedByTagName) {
		if (!taggedByTags.contains(taggedByTagName)) {
			taggedByTags.add(taggedByTagName);
		}
	}

	@Override
	public String toString() {
		return "ContentVO [contentId=" + contentId + ", code=" + code + ", name=" + name + ", description=" + description + ", projectCode=" + projectCode + ", taggedByTags=" + taggedByTags + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((projectCode == null) ? 0 : projectCode.hashCode());
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
		ContentVO other = (ContentVO) obj;
		if (projectCode == null) {
			if (other.projectCode != null)
				return false;
		} else if (!projectCode.equals(other.projectCode))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;

		return true;
	}

}
