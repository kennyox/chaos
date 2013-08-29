package com.chaos.service;

import java.util.List;

import com.chaos.vo.BrandVO;
import com.chaos.vo.RacketVO;

public interface RacketAJAXService {

	public List<RacketVO> getAllRackets();
	
	public List<RacketVO> getAllRacketsByBrand(BrandVO brand);
	
	public List<RacketVO> getRacketsByName(String name);
	
	public List<RacketVO> getRacketsByCode(String name);
	
	public RacketVO getRacketByBrandAndName(BrandVO brand, String name);
	
	public RacketVO getRacketByBrandAndCode(BrandVO brand, String name);
	
}
