package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the country database table.
 * 
 */
@Entity
@Table(name="country")
@NamedQuery(name="Country.findAll", query="SELECT c FROM Country c")
public class Country implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(name="chi_name", length=20)
	private String chiName;

	@Column(length=200)
	private String name;

	//bi-directional many-to-one association to Racket
	@OneToMany(mappedBy="countryBean")
	private List<Racket> rackets;

	public Country() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getChiName() {
		return this.chiName;
	}

	public void setChiName(String chiName) {
		this.chiName = chiName;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Racket> getRackets() {
		return this.rackets;
	}

	public void setRackets(List<Racket> rackets) {
		this.rackets = rackets;
	}

	public Racket addRacket(Racket racket) {
		getRackets().add(racket);
		racket.setCountryBean(this);

		return racket;
	}

	public Racket removeRacket(Racket racket) {
		getRackets().remove(racket);
		racket.setCountryBean(null);

		return racket;
	}

}