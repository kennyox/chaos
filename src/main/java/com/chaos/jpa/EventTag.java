package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the event_tag database table.
 * 
 */
@Entity
@Table(name = "event_tag")
@NamedQuery(name = "EventTag.findAll", query = "SELECT e FROM EventTag e")
public class EventTag extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Event
	@ManyToOne
	private Event event;

	public EventTag() {
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

}