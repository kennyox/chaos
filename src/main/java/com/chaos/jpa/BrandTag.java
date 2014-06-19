package com.chaos.jpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the brand_tag database table.
 * 
 */
@Entity
@Table(name = "brand_tag")
@NamedQuery(name = "BrandTag.findAll", query = "SELECT b FROM BrandTag b")
public class BrandTag extends TaggableItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	// bi-directional many-to-one association to Brand
	@ManyToOne	
	@JoinColumn(name="brand_id")
	private Brand brand;

	public BrandTag() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

}