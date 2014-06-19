package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the racket_tag database table.
 * 
 */
@Entity
@Table(name = "user_tag")
@NamedQuery(name = "UserTag.findAll", query = "SELECT r FROM UserTag r")
public class UserTag extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Racket
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public UserTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}