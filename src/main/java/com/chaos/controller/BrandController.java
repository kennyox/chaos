package com.chaos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaos.service.BrandAJAXService;
import com.chaos.service.RacketAJAXService;
import com.chaos.vo.BrandVO;
import com.chaos.vo.RacketVO;

@Controller
@RequestMapping("/brand")
public class BrandController extends GenericController {

	@Autowired
	protected BrandAJAXService	brandAJAXService;
	
	@Autowired
	protected RacketAJAXService racketAJAXService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody
	List<BrandVO> getAllTag() {
		logger.debug("Received get all brand");
		return brandAJAXService.getAllBrand();
	}

	@RequestMapping(value = "/{brandName}", method = RequestMethod.GET)
	public @ResponseBody
	BrandVO getBrand(@PathVariable String brandName) {
		return brandAJAXService.getBrandByName(brandName);
	}

	@RequestMapping(value = "/{brandName}/racket", method = RequestMethod.GET)
	public @ResponseBody
	List<RacketVO> getBrandRackets(@PathVariable String brandName) {
		BrandVO brand = brandAJAXService.getBrandByName(brandName);
		return racketAJAXService.getAllRacketsByBrand(brand);
	}

}
