package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tag database table.
 * 
 */
@Entity
@NamedQuery(name="Tag.findAll", query="SELECT t FROM Tag t")
public class Tag implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String description;

	private String name;

	//bi-directional many-to-one association to BrandTag
	@OneToMany(mappedBy="tag")
	private List<BrandTag> brandTags;

	//bi-directional many-to-one association to LocationTag
	@OneToMany(mappedBy="tag")
	private List<LocationTag> locationTags;

	//bi-directional many-to-one association to RacketTag
	@OneToMany(mappedBy="tag")
	private List<RacketTag> racketTags;

	public Tag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		brandTag.setTag(this);

		return brandTag;
	}

	public BrandTag removeBrandTag(BrandTag brandTag) {
		getBrandTags().remove(brandTag);
		brandTag.setTag(null);

		return brandTag;
	}

	public List<LocationTag> getLocationTags() {
		return this.locationTags;
	}

	public void setLocationTags(List<LocationTag> locationTags) {
		this.locationTags = locationTags;
	}

	public LocationTag addLocationTag(LocationTag locationTag) {
		getLocationTags().add(locationTag);
		locationTag.setTag(this);

		return locationTag;
	}

	public LocationTag removeLocationTag(LocationTag locationTag) {
		getLocationTags().remove(locationTag);
		locationTag.setTag(null);

		return locationTag;
	}

	public List<RacketTag> getRacketTags() {
		return this.racketTags;
	}

	public void setRacketTags(List<RacketTag> racketTags) {
		this.racketTags = racketTags;
	}

	public RacketTag addRacketTag(RacketTag racketTag) {
		getRacketTags().add(racketTag);
		racketTag.setTag(this);

		return racketTag;
	}

	public RacketTag removeRacketTag(RacketTag racketTag) {
		getRacketTags().remove(racketTag);
		racketTag.setTag(null);

		return racketTag;
	}

}