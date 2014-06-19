package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the location_tag database table.
 * 
 */
@Entity
@Table(name = "level_tag")
@NamedQuery(name = "LevelTag.findAll", query = "SELECT l FROM LevelTag l")
public class LevelTag extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;

	public LevelTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}