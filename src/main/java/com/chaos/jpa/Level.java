package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the level database table.
 * 
 */
@Entity
@NamedQuery(name="Level.findAll", query="SELECT l FROM Level l")
public class Level implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="chi_description")
	private String chiDescription;

	private String description;

	private String name;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="level")
	private List<Event> events;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="level")
	private List<User> users;

	public Level() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiDescription() {
		return this.chiDescription;
	}

	public void setChiDescription(String chiDescription) {
		this.chiDescription = chiDescription;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setLevel(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setLevel(null);

		return event;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setLevel(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setLevel(null);

		return user;
	}

}