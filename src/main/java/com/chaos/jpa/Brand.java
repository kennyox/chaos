package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the brand database table.
 * 
 */
@Entity
@Table(name="brand")
@NamedQuery(name="Brand.findAll", query="SELECT b FROM Brand b")
public class Brand implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=200)
	private String name;

	//bi-directional many-to-one association to BrandTag
	@OneToMany(mappedBy="brand")
	private List<BrandTag> brandTags;

	//bi-directional many-to-one association to Racket
	@OneToMany(mappedBy="brand")
	private List<Racket> rackets;

	public Brand() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<BrandTag> getBrandTags() {
		return this.brandTags;
	}

	public void setBrandTags(List<BrandTag> brandTags) {
		this.brandTags = brandTags;
	}

	public BrandTag addBrandTag(BrandTag brandTag) {
		getBrandTags().add(brandTag);
		brandTag.setBrand(this);

		return brandTag;
	}

	public BrandTag removeBrandTag(BrandTag brandTag) {
		getBrandTags().remove(brandTag);
		brandTag.setBrand(null);

		return brandTag;
	}

	public List<Racket> getRackets() {
		return this.rackets;
	}

	public void setRackets(List<Racket> rackets) {
		this.rackets = rackets;
	}

	public Racket addRacket(Racket racket) {
		getRackets().add(racket);
		racket.setBrand(this);

		return racket;
	}

	public Racket removeRacket(Racket racket) {
		getRackets().remove(racket);
		racket.setBrand(null);

		return racket;
	}

}