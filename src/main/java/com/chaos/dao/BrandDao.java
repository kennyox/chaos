package com.chaos.dao;

import java.util.List;

import com.chaos.jpa.Brand;

public interface BrandDao {
	void save(Brand brand);

	void update(Brand brand);

	void delete(Brand brand);

	List<Brand> getAllBrand();
	
	Brand findByName(String name);

}