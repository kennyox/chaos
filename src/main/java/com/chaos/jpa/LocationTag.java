package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the location_tag database table.
 * 
 */
@Entity
@Table(name="location_tag")
@NamedQuery(name="LocationTag.findAll", query="SELECT l FROM LocationTag l")
public class LocationTag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Location
	@ManyToOne
	private Location location;

	//bi-directional many-to-one association to Tag
	@ManyToOne
	private Tag tag;

	public LocationTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Tag getTag() {
		return this.tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

}