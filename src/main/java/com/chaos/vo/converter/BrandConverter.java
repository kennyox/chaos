package com.chaos.vo.converter;

import org.dozer.CustomConverter;

import com.chaos.jpa.Brand;

public class BrandConverter implements CustomConverter {

	@Override
	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {
		return convertBrand((Brand) source, (String) destination);

	}

	public String convertBrand(Brand brand, String countryString) {
		return brand.getName();
	}

}
