package com.chaos.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class TaggableItem implements Serializable {
	private static final long	serialVersionUID	= 8284200354291283254L;
	private Set<TagVO>			tags;

	public void addAllTags(Set<TagVO> tags) {
		if (tags == null) {
			tags = new HashSet<TagVO>();
		}
		this.tags.addAll(tags);
	}

	public void addTag(TagVO tag) {
		if (tags == null) {
			tags = new HashSet<TagVO>();
		}
		tags.add(tag);
	}

	public void removeTag(TagVO tag) {
		if (tags != null && tags.contains(tag)) {
			tags.remove(tag);
		}
	}

	public void setTags(Set<TagVO> tags) {
		this.tags = tags;
	}

	public Set<TagVO> getTags() {
		return tags;
	}
}
