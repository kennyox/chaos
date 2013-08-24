package com.chaos.util;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

public class EnhancedMapper extends DozerBeanMapper {

	public EnhancedMapper() {
		super();
	}

	public EnhancedMapper(List<String> mappingFiles) {
		super(mappingFiles);
	}

	public <T, U> List<U> listMap( final List<T> source, final Class<U> destType) {

	    final List<U> dest = new ArrayList<U>();

	    for (T element : source) {
	        dest.add(this.map(element, destType));
	    }

	    return dest;
	}
}
