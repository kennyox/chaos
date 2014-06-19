package com.chaos.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the event database table.
 * 
 */
@Entity
@NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e")
public class Event implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar date;

	// bi-directional many-to-one association to Location
	@ManyToOne
	@JoinColumn(name="location_id")
	private Location location;

	// bi-directional many-to-one association to Level
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;

	@Column(name = "public_event")
	private byte publicEvent;

	@Column(name = "status")
	private int status;

	@Column(name = "game_type")
	private int gameType;

	@Column(name = "max_participant")
	private int maxParticipant;

	@Column(name = "remark")
	private String remark;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "creator_id")
	private User user;

	@Column(name = "create_date")
	private Timestamp createDate;

	// bi-directional many-to-one association to EventAdmin
	@OneToMany(mappedBy = "event")
	private List<EventAdmin> eventAdmins;

	// bi-directional many-to-one association to EventInvitee
	@OneToMany(mappedBy = "event")
	private List<EventInvitee> eventInvitees;

	// bi-directional many-to-one association to EventParticipant
	@OneToMany(mappedBy = "event")
	private List<EventParticipant> eventParticipants;

	// bi-directional many-to-one association to EventTag
	@OneToMany(mappedBy = "event")
	private List<EventTag> eventTags;

	// bi-directional many-to-one association to EventTag
	@OneToMany(mappedBy = "event")
	private List<EventDetails> eventDetails;

	public Event() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Calendar getDate() {
		return this.date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public int getMaxParticipant() {
		return this.maxParticipant;
	}

	public void setMaxParticipant(int maxParticipant) {
		this.maxParticipant = maxParticipant;
	}

	public byte getPublicEvent() {
		return this.publicEvent;
	}

	public void setPublicEvent(byte publicEvent) {
		this.publicEvent = publicEvent;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<EventAdmin> getEventAdmins() {
		return this.eventAdmins;
	}

	public void setEventAdmins(List<EventAdmin> eventAdmins) {
		this.eventAdmins = eventAdmins;
	}

	public EventAdmin addEventAdmin(EventAdmin eventAdmin) {
		getEventAdmins().add(eventAdmin);
		eventAdmin.setEvent(this);

		return eventAdmin;
	}

	public EventAdmin removeEventAdmin(EventAdmin eventAdmin) {
		getEventAdmins().remove(eventAdmin);
		eventAdmin.setEvent(null);

		return eventAdmin;
	}

	public List<EventInvitee> getEventInvitees() {
		return this.eventInvitees;
	}

	public void setEventInvitees(List<EventInvitee> eventInvitees) {
		this.eventInvitees = eventInvitees;
	}

	public EventInvitee addEventInvitee(EventInvitee eventInvitee) {
		getEventInvitees().add(eventInvitee);
		eventInvitee.setEvent(this);

		return eventInvitee;
	}

	public EventInvitee removeEventInvitee(EventInvitee eventInvitee) {
		getEventInvitees().remove(eventInvitee);
		eventInvitee.setEvent(null);

		return eventInvitee;
	}

	public List<EventParticipant> getEventParticipants() {
		return this.eventParticipants;
	}

	public void setEventParticipants(List<EventParticipant> eventParticipants) {
		this.eventParticipants = eventParticipants;
	}

	public EventParticipant addEventParticipant(
			EventParticipant eventParticipant) {
		getEventParticipants().add(eventParticipant);
		eventParticipant.setEvent(this);

		return eventParticipant;
	}

	public EventParticipant removeEventParticipant(
			EventParticipant eventParticipant) {
		getEventParticipants().remove(eventParticipant);
		eventParticipant.setEvent(null);

		return eventParticipant;
	}

	public List<EventTag> getEventTags() {
		return this.eventTags;
	}

	public void setEventTags(List<EventTag> eventTags) {
		this.eventTags = eventTags;
	}

	public EventTag addEventTag(EventTag eventTag) {
		getEventTags().add(eventTag);
		eventTag.setEvent(this);

		return eventTag;
	}

	public EventTag removeEventTag(EventTag eventTag) {
		getEventTags().remove(eventTag);
		eventTag.setEvent(null);

		return eventTag;
	}

	public List<EventDetails> getEventDetails() {
		return eventDetails;
	}

	public void setEventDetails(List<EventDetails> eventDetails) {
		this.eventDetails = eventDetails;
	}

	public EventDetails addEventDetails(EventDetails eventdetails) {
		getEventDetails().add(eventdetails);
		eventdetails.setEvent(this);

		return eventdetails;
	}

	public EventDetails removeEventDetails(EventDetails eventdetails) {
		getEventDetails().remove(eventdetails);
		eventdetails.setEvent(null);
		return eventdetails;
	}

}