package com.chaos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.dao.BrandDao;
import com.chaos.service.BrandAJAXService;
import com.chaos.vo.BrandVO;

@Service("brandAJAXService")
public class BrandAJAXServiceImpl extends GenericService implements
		BrandAJAXService {

	BrandDao	brandDao;

	@Autowired
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}

	@Override
	@Transactional
	public List<BrandVO> getAllBrand() {
		return mapper.convertList(brandDao.getAllBrand(), BrandVO.class);
	}

	@Override
	@Transactional
	public BrandVO getBrandByName(String name) {
		return mapper.map(brandDao.findByName(name), BrandVO.class);
	}

}
