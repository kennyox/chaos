package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the racket database table.
 * 
 */
@Entity
@NamedQuery(name = "Racket.findAll", query = "SELECT r FROM Racket r")
public class Racket implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "balance_point")
	private double balancePoint;

	@Column(name = "code")
	private String code;

	@Column(name = "color")
	private String color;

	@Column(name = "frame")
	private String frame;

	@Column(name = "grip")
	private String grip;

	@Column(name = "name")
	private String name;

	@Column(name = "remarks")
	private String remarks;

	@Column(name = "shaft")
	private String shaft;

	@Column(name = "weight")
	private String weight;

	// bi-directional many-to-one association to Brand
	@ManyToOne
	@JoinColumn(name="brand_id")
	private Brand brand;

	// bi-directional many-to-one association to RacketTag
	@OneToMany(mappedBy = "racket")
	private List<RacketTag> racketTags;

	public Racket() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalancePoint() {
		return this.balancePoint;
	}

	public void setBalancePoint(double balancePoint) {
		this.balancePoint = balancePoint;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getFrame() {
		return this.frame;
	}

	public void setFrame(String frame) {
		this.frame = frame;
	}

	public String getGrip() {
		return this.grip;
	}

	public void setGrip(String grip) {
		this.grip = grip;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getShaft() {
		return this.shaft;
	}

	public void setShaft(String shaft) {
		this.shaft = shaft;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public List<RacketTag> getRacketTags() {
		return this.racketTags;
	}

	public void setRacketTags(List<RacketTag> racketTags) {
		this.racketTags = racketTags;
	}

	public RacketTag addRacketTag(RacketTag racketTag) {
		getRacketTags().add(racketTag);
		racketTag.setRacket(this);

		return racketTag;
	}

	public RacketTag removeRacketTag(RacketTag racketTag) {
		getRacketTags().remove(racketTag);
		racketTag.setRacket(null);

		return racketTag;
	}

}