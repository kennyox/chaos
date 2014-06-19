package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the event_admin database table.
 * 
 */
@Entity
@Table(name="event_admin")
@NamedQuery(name="EventAdmin.findAll", query="SELECT e FROM EventAdmin e")
public class EventAdmin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="update_dtm")
	private Timestamp updateDtm;

	//bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name="event_id")
	private Event event;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public EventAdmin() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getUpdateDtm() {
		return this.updateDtm;
	}

	public void setUpdateDtm(Timestamp updateDtm) {
		this.updateDtm = updateDtm;
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