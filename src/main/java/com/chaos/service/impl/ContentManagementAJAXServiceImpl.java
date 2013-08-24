package com.chaos.service.impl;

import org.springframework.transaction.annotation.Transactional;

import com.chaos.jpa.Content;
import com.chaos.jpa.Tag;
import com.chaos.service.ContentManagementAJAXService;
import com.chaos.vo.ContentVO;
import com.chaos.vo.TagVO;

public class ContentManagementAJAXServiceImpl extends CommonContentManagementServiceImpl implements
		ContentManagementAJAXService {
	@Transactional
	@Override
	public TagVO taggingATag(String projectCode, String sourceTagName, String targetTagName) {
		Tag sourceTag = retrieveTagByName(projectCode, sourceTagName,true);
		Tag targetTag = retrieveTagByName(projectCode, targetTagName,true);
		if (sourceTag.addTaggedTag(targetTag)) {
			tagDao.update(sourceTag);
			tagDao.update(targetTag);
		}
		return mapper.map(targetTag, TagVO.class);
	}

	@Transactional
	@Override
	public ContentVO taggingAContent(String projectCode, String code, String taggedByTagNames) {
		Content content = contentDao.findByCode(projectCode, code);
		content = taggingAContent(content, taggedByTagNames);
		return mapper.map(content, ContentVO.class);
	}
}
