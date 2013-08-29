package com.chaos.service;

import java.util.List;

import com.chaos.vo.BrandVO;

public interface BrandAJAXService {

	public List<BrandVO> getAllBrand();
	
	public BrandVO getBrandByName(String name);
}
