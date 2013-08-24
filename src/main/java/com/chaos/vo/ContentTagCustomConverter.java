package com.chaos.vo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.dozer.ConfigurableCustomConverter;

import com.chaos.jpa.Content;
import com.chaos.jpa.Tag;

public class ContentTagCustomConverter implements ConfigurableCustomConverter {

	private String param;

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
		if ("content".equalsIgnoreCase(param)) {
			return covertContentSetToStringSet((Set<Content>) source, (Set<Map<String, String>>) destination);
		} else if ("tag".equalsIgnoreCase(param)) {
			return covertTagSetToStringSet((Set<Tag>) source, (Set<Map<String, String>>) destination);
		} else {
			throw new RuntimeException("unexpected param");
		}

	}

	public Set<Map<String, String>> covertContentSetToStringSet(Set<Content> source, Set<Map<String, String>> destination) {
		if (destination == null) {
			destination = new HashSet<Map<String, String>>();
		}
		for (Content sourceObject : source) {
			if (sourceObject != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", sourceObject.getName());
				map.put("code", sourceObject.getCode());
				map.put("desc", sourceObject.getDescription());
				destination.add(map);
			}
		}
		return destination;
	}

	public Set<Map<String, String>> covertTagSetToStringSet(Set<Tag> source, Set<Map<String, String>> destination) {
		if (destination == null) {
			destination = new HashSet<Map<String, String>>();
		}
		for (Tag sourceObject : source) {
			if (sourceObject != null) {
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", sourceObject.getName());
				map.put("desc", sourceObject.getDescription());
				destination.add(map);
			}
		}
		return destination;
	}

	@Override
	public void setParameter(String parameter) {
		this.param = parameter;

	}

}
