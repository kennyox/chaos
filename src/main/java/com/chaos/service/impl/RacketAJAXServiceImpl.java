package com.chaos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.dao.RacketDao;
import com.chaos.service.RacketAJAXService;
import com.chaos.vo.BrandVO;
import com.chaos.vo.RacketVO;

@Service("racketAJAXService")
public class RacketAJAXServiceImpl extends GenericService implements
		RacketAJAXService {

	RacketDao	racketDao;

	@Autowired
	public void setRacketDao(RacketDao racketDao) {
		this.racketDao = racketDao;
	}

	@Override
	@Transactional
	public List<RacketVO> getAllRackets() {
		return mapper.convertList(racketDao.getAllRackets(), RacketVO.class);
	}

	@Override
	@Transactional
	public List<RacketVO> getAllRacketsByBrand(BrandVO brand) {
		return mapper.convertList(racketDao.getAllRacketsByBrand(brand.getId()), RacketVO.class);
	}

	@Override
	@Transactional
	public List<RacketVO> getRacketsByName(String name) {
		return mapper.convertList(racketDao.findByName(name), RacketVO.class);
	}

	@Override
	@Transactional
	public List<RacketVO> getRacketsByCode(String code) {
		return mapper.convertList(racketDao.findByCode(code), RacketVO.class);
	}
	
	@Override
	@Transactional
	public RacketVO getRacketByBrandAndName(BrandVO brand, String name) {
		return mapper.map(racketDao.findByBrandAndName(brand.getId(),name), RacketVO.class);
	}

	@Override
	@Transactional
	public RacketVO getRacketByBrandAndCode(BrandVO brand, String code) {
		return mapper.map(racketDao.findByBrandAndCode(brand.getId(),code), RacketVO.class);
	}
	
}
