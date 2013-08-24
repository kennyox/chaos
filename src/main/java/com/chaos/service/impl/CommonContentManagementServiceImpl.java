package com.chaos.service.impl;

import com.chaos.jpa.Content;
import com.chaos.jpa.Tag;

public abstract class CommonContentManagementServiceImpl extends GenericService {

	public CommonContentManagementServiceImpl() {
		super();
	}

	protected Tag retrieveTagByName(String projectCode, String name, boolean autoCreate) {
		Tag newTag = tagDao.findByName(projectCode, name);
		if (newTag == null && autoCreate) {
			newTag = new Tag();
			newTag.setName(name);
			newTag.setProjectCode(projectCode);
			tagDao.save(newTag);
		}
		return newTag;
	}

	protected Tag taggingATag(Tag taggedTag, String... taggedByTagNames) {
		for (String tagName : taggedByTagNames) {
			if (!"".equals(tagName)) {
				Tag taggedByTag = retrieveTagByName(taggedTag.getProjectCode(), tagName, true);
				if (taggedByTag.addTaggedTag(taggedTag)) {
					tagDao.update(taggedTag);
					tagDao.update(taggedByTag);
				}
			}
		}
		return taggedTag;
	}

	protected Content taggingAContent(Content content, String... taggedByTagNames) {
		for (String tagName : taggedByTagNames) {
			if (!"".equals(tagName)) {
				Tag tag = retrieveTagByName(content.getProjectCode(), tagName,true);
				if (tag.addTaggedContent(content)) {
					tagDao.update(tag);
					contentDao.update(content);
				}
			}
		}
		return content;
	}

}