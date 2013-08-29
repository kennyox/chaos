package com.chaos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chaos.dao.TagDao;
import com.chaos.service.TagAJAXService;
import com.chaos.vo.TagVO;

@Service("tagAJAXService")
public class TagAJAXServiceImpl extends GenericService implements
		TagAJAXService {

	protected TagDao tagDao;

	@Autowired
	public void setTagDao(TagDao tagDao) {
		this.tagDao = tagDao;
	}

	@Override
	@Transactional
	public List<TagVO> getAllTag() {
		return mapper.convertList(tagDao.getAllTag(), TagVO.class);
	}

}
