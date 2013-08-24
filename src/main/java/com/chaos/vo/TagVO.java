package com.chaos.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TagVO implements Serializable {

	private static final long serialVersionUID = 5540923016702506020L;
	private Long tagId;
	private String name;
	private String description;
	private String projectCode;

	private Set<Map<String, String>> taggedContents = new HashSet<Map<String, String>>();

	private Set<Map<String, String>> taggedTags = new HashSet<Map<String, String>>();

	private Set<Map<String, String>> taggedByTags = new HashSet<Map<String, String>>();

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getName() {
		return name;
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

	public Set<Map<String, String>> getTaggedContents() {
		return taggedContents;
	}

	public void setTaggedContents(Set<Map<String, String>> taggedContents) {
		this.taggedContents = taggedContents;
	}

	public boolean addTaggedContent(Map<String, String> taggedContent) {
		if (!taggedContents.contains(taggedContent)) {
			taggedContents.add(taggedContent);
			return true;
		}
		return false;
	}

	public Set<Map<String, String>> getTaggedTags() {
		return taggedTags;
	}

	public void setTaggedTags(Set<Map<String, String>> taggedTags) {
		this.taggedTags = taggedTags;
	}

	public boolean addTaggedTags(Map<String, String> taggedTag) {
		if (!taggedTags.contains(taggedTag)) {
			taggedTags.add(taggedTag);
			return true;
		}
		return false;
	}

	public Set<Map<String, String>> getTaggedByTags() {
		return taggedByTags;
	}

	public void setTaggedByTags(Set<Map<String, String>> taggedByTags) {
		this.taggedByTags = taggedByTags;
	}

	public boolean addTaggedByTags(Map<String, String> taggedTag) {
		if (!taggedByTags.contains(taggedTag)) {
			taggedByTags.add(taggedTag);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "TagVO [tagId=" + tagId + ", name=" + name + ", description=" + description + ", projectCode=" + projectCode + ", taggedContents=" + taggedContents + ", taggedTags=" + taggedTags + ", taggedByTags=" + taggedByTags + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		TagVO other = (TagVO) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (projectCode == null) {
			if (other.projectCode != null)
				return false;
		} else if (!projectCode.equals(other.projectCode))
			return false;
		return true;
	}

}
