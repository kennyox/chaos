package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.RacketDao;
import com.chaos.jpa.Racket;

@Repository("racketDao")
public class RacketDaoImpl extends CommonDao implements RacketDao {

	public void save(Racket racket) {
		getCurrentSession().save(racket);

	}

	public void update(Racket racket) {
		getCurrentSession().update(racket);

	}

	public void delete(Racket racket) {
		getCurrentSession().delete(racket);

	}

	@Override
	public List<Racket> getAllRackets() {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().getNamedQuery("Racket.findAll").list();
		return result;
	}
	
	@Override
	public List<Racket> getAllRacketsByBrand(int brandId) {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().createQuery("from Racket where brand_id=:brandId").setParameter("brandId",brandId).list();
		return result;
	}

	@Override
	public List<Racket> findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().createQuery("from Racket where name=:name").setParameter("name",name).list();
		return result;
	}

	@Override
	public List<Racket> findByCode(String code) {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().createQuery("from Racket where code=:code").setParameter("code",code).list();
		return result;
	}
	
	@Override
	public Racket findByBrandAndName(int brandId, String name) {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().createQuery("from Racket where brand_id =:brandId and name=:name").setParameter("brandId",brandId).setParameter("name",name).list();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

	@Override
	public Racket findByBrandAndCode(int brandId, String code) {
		@SuppressWarnings("unchecked")
		List<Racket> result = getCurrentSession().createQuery("from Racket where brand_id =:brandId and code=:code").setParameter("brandId",brandId).setParameter("code",code).list();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}
	
	
}
