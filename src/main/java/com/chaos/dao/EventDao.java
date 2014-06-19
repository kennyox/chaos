package com.chaos.dao;

import com.chaos.jpa.Event;
import com.chaos.vo.EventSearchCriteriaVO;

public interface EventDao {

	public void save(Event event);

	public void update(Event event);

	public void delete(Event event);

	public void findBySearchCriteria(EventSearchCriteriaVO criteria);
	
	public void findByTag();
}
