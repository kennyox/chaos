package com.chaos.vo.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dozer.ConfigurableCustomConverter;

import com.chaos.jpa.BrandTag;
import com.chaos.jpa.RacketTag;
import com.chaos.jpa.Tag;
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
		if(parameter.equals("BRNAD")){
			return convertBrandTag((List<BrandTag>) source, (Set<TagVO>) destination);
		}else if(parameter.equals("RACKET")){
			return  convertRacketTag((List<RacketTag>) source, (Set<TagVO>) destination);
		}else{
			return null;
		}
		

	}

	public Set<TagVO> convertBrandTag(List<BrandTag> tags, Set<TagVO> tagsVO) {
		if(tagsVO ==null){
			tagsVO = new HashSet<TagVO>();
		}
		if(tags != null){
			for(BrandTag brandTag : tags){
				TagVO vo = new TagVO();
				Tag tag = brandTag.getTag();
				
				vo.setId(tag.getId());
				vo.setName(tag.getName());
				vo.setDescription(tag.getDescription());
				tagsVO.add(vo);
			}
		}
			
		return tagsVO;
			
	}

	public Set<TagVO> convertRacketTag(List<RacketTag> tags, Set<TagVO> tagsVO) {
		if(tagsVO ==null){
			tagsVO = new HashSet<TagVO>();
		}
		if(tags != null){
			for(RacketTag racketTag : tags){
				TagVO vo = new TagVO();
				Tag tag = racketTag.getTag();
				
				vo.setId(tag.getId());
				vo.setName(tag.getName());
				vo.setDescription(tag.getDescription());
				tagsVO.add(vo);
			}
		}
			
		return tagsVO;
			
	}
	

}
