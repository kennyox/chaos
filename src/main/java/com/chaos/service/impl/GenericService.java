package com.chaos.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.chaos.util.EnhancedMapper;

public abstract class GenericService {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	protected EnhancedMapper mapper;

	@Autowired
	public void setMapper(EnhancedMapper mapper) {
		this.mapper = mapper;
	}

}
