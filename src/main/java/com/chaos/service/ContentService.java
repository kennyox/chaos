package com.chaos.service;

import java.util.List;

import com.chaos.vo.ContentVO;
import com.chaos.vo.TagVO;

public interface ContentService {
	public List<TagVO> getAllTag(String projectCode);

	public TagVO getTagByName(String projectCode, String name);

	public List<ContentVO> getAllContent(String projectCode);

	public ContentVO getContentByCode(String projectCode, String code);

}
