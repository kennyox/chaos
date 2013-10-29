package com.chaos.vo;

import java.io.Serializable;
import java.util.Date;

import com.chaos.jpa.Tag;

public class EventSearchCriteriaVO implements Serializable{

	private static final long serialVersionUID = 3154797151654752319L;
	private int locationId;
	private Date eventDate;
	private Tag eventTag;
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	public Date getEventDate() {
		return eventDate;
	}
	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	public Tag getEventTag() {
		return eventTag;
	}
	public void setEventTag(Tag eventTag) {
		this.eventTag = eventTag;
	}
	
	
}
