package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name = "TagGroup.findAll", query = "SELECT t FROM TagGroup t")
public class TagGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	// bi-directional many-to-one association to Brand
	@OneToMany(mappedBy = "tagGroup")
	private List<TagGroupList> tagGroupList;

	public TagGroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TagGroupList> getTagGroupList() {
		return tagGroupList;
	}

	public void setTagGroupList(List<TagGroupList> tagGroupList) {
		this.tagGroupList = tagGroupList;
	}

	public TagGroupList addTagGroupList(TagGroupList tagGroupList) {
		getTagGroupList().add(tagGroupList);
		tagGroupList.setTagGroup(this);

		return tagGroupList;
	}

	public TagGroupList removeTagGroupList(TagGroupList tagGroupList) {
		getTagGroupList().remove(tagGroupList);
		tagGroupList.setTagGroup(null);

		return tagGroupList;
	}

}