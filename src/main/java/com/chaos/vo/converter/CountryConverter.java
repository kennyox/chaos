package com.chaos.vo.converter;

import org.dozer.CustomConverter;

import com.chaos.jpa.Country;

public class CountryConverter implements CustomConverter {

	@Override
	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {
		return convertCountry((Country) source, (String) destination);

	}

	public String convertCountry(Country country, String countryString) {
		return country.getName();
	}

}
