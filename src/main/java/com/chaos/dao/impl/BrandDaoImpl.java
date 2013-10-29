package com.chaos.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.chaos.dao.BrandDao;
import com.chaos.jpa.Brand;

@Repository("brandDao")
public class BrandDaoImpl extends CommonDao implements BrandDao {

	public void save(Brand brand) {
		getEm().persist(brand);
	}

	public void update(Brand brand) {
		getEm().merge(brand);

	}

	public void delete(Brand brand) {
		getEm().remove(brand);

	}

	@Override
	public List<Brand> getAllBrand() {
		@SuppressWarnings("unchecked")
		List<Brand> result = getEm().createNamedQuery("Brand.findAll").getResultList();
		return result;
	}

	@Override
	public Brand findByName(String name) {
		@SuppressWarnings("unchecked")
		List<Brand> result = getEm().createQuery("from Brand where name=:name").setParameter("name",name).getResultList();
		if (result != null && result.size() == 1) {
			return result.get(0);
		}
		return null;
	}

}
