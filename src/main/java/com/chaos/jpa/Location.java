package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@Table(name="location")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(nullable=false, length=2000)
	private String address;

	@Column(name="google_map_url", length=5000)
	private String googleMapUrl;

	@Column(length=10)
	private String phone;

	//bi-directional many-to-one association to LocationTag
	@OneToMany(mappedBy="location")
	private List<LocationTag> locationTags;

	public Location() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGoogleMapUrl() {
		return this.googleMapUrl;
	}

	public void setGoogleMapUrl(String googleMapUrl) {
		this.googleMapUrl = googleMapUrl;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<LocationTag> getLocationTags() {
		return this.locationTags;
	}

	public void setLocationTags(List<LocationTag> locationTags) {
		this.locationTags = locationTags;
	}

	public LocationTag addLocationTag(LocationTag locationTag) {
		getLocationTags().add(locationTag);
		locationTag.setLocation(this);

		return locationTag;
	}

	public LocationTag removeLocationTag(LocationTag locationTag) {
		getLocationTags().remove(locationTag);
		locationTag.setLocation(null);

		return locationTag;
	}

}