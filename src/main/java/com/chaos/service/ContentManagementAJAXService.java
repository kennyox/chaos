package com.chaos.service;

import com.chaos.vo.ContentVO;
import com.chaos.vo.TagVO;

public interface ContentManagementAJAXService {

	public ContentVO taggingAContent(String projectCode, String code, String taggedByTagNames);

	public TagVO taggingATag(String projectCode, String sourceTagName, String targetTagName);

}
