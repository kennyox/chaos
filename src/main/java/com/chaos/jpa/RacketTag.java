package com.chaos.jpa;

import java.io.Serializable;

import javax.persistence.*;

/**
 * The persistent class for the racket_tag database table.
 * 
 */
@Entity
@Table(name = "racket_tag")
@NamedQuery(name = "RacketTag.findAll", query = "SELECT r FROM RacketTag r")
public class RacketTag extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Racket
	@ManyToOne
	@JoinColumn(name="racket_id")
	private Racket racket;

	public RacketTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Racket getRacket() {
		return this.racket;
	}

	public void setRacket(Racket racket) {
		this.racket = racket;
	}

}