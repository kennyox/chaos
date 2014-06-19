package com.chaos.jpa;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name = "EventDetails.findAll", query = "SELECT e FROM EventDetails e")
public class EventDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Event
	@ManyToOne
	@JoinColumn(name = "event_id")
	private Event event;

	@Column(name = "court_no")
	private int courtNo;

	@Column(name = "start_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startTime;

	@Column(name = "end_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar endTime;

	public EventDetails() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public int getCourtNo() {
		return courtNo;
	}

	public void setCourtNo(int courtNo) {
		this.courtNo = courtNo;
	}

	public Calendar getStartTime() {
		return startTime;
	}

	public void setStartTime(Calendar startTime) {
		this.startTime = startTime;
	}

	public Calendar getEndTime() {
		return endTime;
	}

	public void setEndTime(Calendar endTime) {
		this.endTime = endTime;
	}

}