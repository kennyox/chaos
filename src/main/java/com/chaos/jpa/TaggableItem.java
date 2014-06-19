package com.chaos.jpa;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class TaggableItem {

	// bi-directional many-to-one association to Tag
	@ManyToOne
	@JoinColumn(name="tag_id")
	private Tag tag;

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}
