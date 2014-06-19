package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "create_dtm")
	private Timestamp createDtm;

	private String email;

	@Column(name = "first_name")
	private String firstName;

	private String icon;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "last_update_dtm")
	private Timestamp lastUpdateDtm;

	@Column(name = "nick_name")
	private String nickName;

	private String password;

	@Column(name = "user_name")
	private String userName;

	// bi-directional many-to-one association to Event
	@OneToMany(mappedBy = "user")
	private List<Event> events;

	// bi-directional many-to-one association to EventAdmin
	@OneToMany(mappedBy = "user")
	private List<EventAdmin> eventAdmins;

	// bi-directional many-to-one association to EventInvitee
	@OneToMany(mappedBy = "user")
	private List<EventInvitee> eventInvitees;

	// bi-directional many-to-one association to EventParticipant
	@OneToMany(mappedBy = "user")
	private List<EventParticipant> eventParticipants;

	// bi-directional many-to-one association to Level
	@ManyToOne
	@JoinColumn(name="level_id")
	private Level level;

	// bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy = "user")
	private List<UserRole> userRoles;

	// bi-directional many-to-one association to RacketTag
	@OneToMany(mappedBy = "user")
	private List<UserTag> userTags;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Timestamp createDtm) {
		this.createDtm = createDtm;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdateDtm() {
		return this.lastUpdateDtm;
	}

	public void setLastUpdateDtm(Timestamp lastUpdateDtm) {
		this.lastUpdateDtm = lastUpdateDtm;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}

	public List<EventAdmin> getEventAdmins() {
		return this.eventAdmins;
	}

	public void setEventAdmins(List<EventAdmin> eventAdmins) {
		this.eventAdmins = eventAdmins;
	}

	public EventAdmin addEventAdmin(EventAdmin eventAdmin) {
		getEventAdmins().add(eventAdmin);
		eventAdmin.setUser(this);

		return eventAdmin;
	}

	public EventAdmin removeEventAdmin(EventAdmin eventAdmin) {
		getEventAdmins().remove(eventAdmin);
		eventAdmin.setUser(null);

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
		eventInvitee.setUser(this);

		return eventInvitee;
	}

	public EventInvitee removeEventInvitee(EventInvitee eventInvitee) {
		getEventInvitees().remove(eventInvitee);
		eventInvitee.setUser(null);

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
		eventParticipant.setUser(this);

		return eventParticipant;
	}

	public EventParticipant removeEventParticipant(
			EventParticipant eventParticipant) {
		getEventParticipants().remove(eventParticipant);
		eventParticipant.setUser(null);

		return eventParticipant;
	}

	public Level getLevel() {
		return this.level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

	public List<UserTag> getUserTags() {
		return userTags;
	}

	public void setUserTags(List<UserTag> userTags) {
		this.userTags = userTags;
	}

	public UserTag addUserRole(UserTag userTags) {
		getUserTags().add(userTags);
		userTags.setUser(this);

		return userTags;
	}

	public UserTag removeUserRole(UserTag userTags) {
		getUserTags().remove(userTags);
		userTags.setUser(null);

		return userTags;
	}

}