package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the event_participant database table.
 * 
 */
@Entity
@Table(name="event_participant")
@NamedQuery(name="EventParticipant.findAll", query="SELECT e FROM EventParticipant e")
public class EventParticipant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	//bi-directional many-to-one association to User
	@ManyToOne
	private User user;

	public EventParticipant() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return this.event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}