package com.chaos.service;

import com.chaos.vo.ContentVO;
import com.chaos.vo.TagVO;

public interface ContentManagementService extends ContentService {

	/**
	 * get tag by name, if not exist, create new one
	 * 
	 * @param projectCode
	 * @param name
	 * @return
	 */
	public TagVO getTagByName(String projectCode, String name, boolean autoCreate);

	public TagVO updateTag(String projectCode, String tagName, String description, String... taggedByTagNames);

	public ContentVO createContent(String projectCode, String code, String name, String description, String... taggedByTagNames);

	public ContentVO updateContent(String projectCode, String code, String description, String... taggedByTagNames);

}
