package com.chaos.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.jpa.Content;
import com.chaos.jpa.Tag;
import com.chaos.service.ContentManagementService;
import com.chaos.vo.ContentVO;
import com.chaos.vo.TagVO;

@Service("contentService")
public class ContentManagementServiceImpl extends
		CommonContentManagementServiceImpl implements ContentManagementService {

	@Transactional
	@Override
	public List<TagVO> getAllTag(String projectCode) {
		return mapper.<Tag, TagVO> listMap(tagDao.getAllTag(projectCode), TagVO.class);
	}

	@Override
	public TagVO getTagByName(String projectCode, String name) {
		return getTagByName(projectCode,name,false);
	}

	@Transactional
	@Override
	public TagVO getTagByName(String projectCode, String name, boolean autoCreate) {
		Tag newTag = retrieveTagByName(projectCode, name, autoCreate);
		return mapper.map(newTag, TagVO.class);
	}

	@Transactional
	@Override
	public TagVO updateTag(String projectCode, String tagName, String description, String... taggedByTagNames) {
		logger.debug("tagged:{}", taggedByTagNames);
		Tag tag = retrieveTagByName(projectCode, tagName, true);
		tag.setDescription(description);
		tagDao.update(tag);
		for (String taggedByTagName : taggedByTagNames) {
			if (!"".equals(taggedByTagName)) {
				taggingATag(tag, taggedByTagName);
			}
		}
		return mapper.map(tag, TagVO.class);
	}

	@Override
	public List<ContentVO> getAllContent(String projectCode) {
		return mapper.<Content, ContentVO> listMap(contentDao.getAllContent(projectCode), ContentVO.class);
	}

	@Override
	public ContentVO createContent(String projectCode, String code, String name, String description, String... taggedByTagNames) {
		Content content = contentDao.findByCode(projectCode, code);
		if (content == null) {
			content = new Content();
			content.setProjectCode(projectCode);
			content.setCode(code);
			content.setName(name);
			content.setDescription(description.trim());
			contentDao.save(content);
			content = taggingAContent(content, taggedByTagNames);
			contentDao.update(content);
			return mapper.map(content, ContentVO.class);
		} else {
			return null;
		}

	}

	@Override
	public ContentVO getContentByCode(String projectCode, String code) {
		ContentVO result = null;
		result = mapper.map(contentDao.findByCode(projectCode, code), ContentVO.class);
		return result;
	}

	@Transactional
	@Override
	public ContentVO updateContent(String projectCode, String code, String description, String... taggedByTagNames) {
		Content content = contentDao.findByCode(projectCode, code);
		content.setDescription(description.trim());

		content = taggingAContent(content, taggedByTagNames);
		contentDao.update(content);
		return mapper.map(content, ContentVO.class);
	}

}
