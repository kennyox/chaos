package com.chaos.vo.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.dozer.ConfigurableCustomConverter;

import com.chaos.jpa.BrandTag;
import com.chaos.jpa.RacketTag;
import com.chaos.jpa.Tag;
import com.chaos.jpa.TaggableItem;
import com.chaos.vo.TagVO;

public class TagConverter implements ConfigurableCustomConverter {

	private String parameter;

	@Override
	public void setParameter(String parameter) {
		this.parameter = parameter;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object destination, Object source,
			Class<?> destinationClass, Class<?> sourceClass) {
		if (StringUtils.equalsIgnoreCase(parameter, "tag")) {
			return convertTag((List<TaggableItem>) source,
					(Set<TagVO>) destination);
		} else {
			return null;
		}

	}

	public Set<TagVO> convertTag(List<TaggableItem> tags, Set<TagVO> tagsVO) {
		if (tagsVO == null) {
			tagsVO = new HashSet<TagVO>();
		}
		if (tags != null) {
			for (TaggableItem tagItem : tags) {
				TagVO vo = new TagVO();
				Tag tag = tagItem.getTag();

				vo.setId(tag.getId());
				vo.setName(tag.getName());
				vo.setDescription(tag.getDescription());
				tagsVO.add(vo);
			}
		}

		return tagsVO;

	}

}
