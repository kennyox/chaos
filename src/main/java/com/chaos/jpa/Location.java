package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the location database table.
 * 
 */
@Entity
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String address;

	@Column(name="google_map_url")
	private String googleMapUrl;

	private String name;

	private String phone;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="location")
	private List<Event> events;

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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setLocation(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setLocation(null);

		return event;
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