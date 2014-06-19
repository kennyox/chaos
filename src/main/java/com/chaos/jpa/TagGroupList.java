package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name = "TagGroupList.findAll", query = "SELECT t FROM TagGroupList t")
public class TagGroupList extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Event
	@ManyToOne
	private TagGroup tagGroup;

	public TagGroupList() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TagGroup getTagGroup() {
		return tagGroup;
	}

	public void setTagGroup(TagGroup tagGroup) {
		this.tagGroup = tagGroup;
	}

}