package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.BrandDao;
import com.chaos.jpa.Brand;

@Repository("brandDao")
public class BrandDaoImpl extends CommonDao implements BrandDao {

	public void save(Brand brand) {
		getCurrentSession().save(brand);

	}

	public void update(Brand brand) {
		getCurrentSession().update(brand);

	}

	public void delete(Brand brand) {
		getCurrentSession().delete(brand);

	}

	@Override
	public List<Brand> getAllBrand() {
		@SuppressWarnings("unchecked")
		List<Brand> result = getCurrentSession().getNamedQuery("Brand.findAll").list();
		return result;
	}

	@Override
	public Brand findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Brand> result = getCurrentSession().createQuery("from Brand where name=:name").setParameter("name",name).list();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
