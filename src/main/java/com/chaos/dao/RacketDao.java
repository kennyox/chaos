package com.chaos.dao;

import java.util.List;

import com.chaos.jpa.Racket;

public interface RacketDao {
	void save(Racket racket);

	void update(Racket racket);

	void delete(Racket racket);

	List<Racket> getAllRackets();
	
	List<Racket> getAllRacketsByBrand(int brandId);
	
	List<Racket> findByName(String name);
	
	List<Racket> findByCode(String code);
	
	Racket findByBrandAndName(int brandId, String name);
	
	Racket findByBrandAndCode(int brandId, String code);

}