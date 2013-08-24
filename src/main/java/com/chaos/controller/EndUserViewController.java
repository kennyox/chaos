package com.chaos.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.constant.SpecialTag;
import com.chaos.service.ContentService;
import com.chaos.service.ProjectService;
import com.chaos.vo.ContentVO;
import com.chaos.vo.ProjectVO;
import com.chaos.vo.TagVO;

@Controller
@RequestMapping("/")
public class EndUserViewController extends GenericController {

	private ContentService contentService;
	private ProjectService projectService;

	@Autowired
	public void setContentService(ContentService contentService) {
		this.contentService = contentService;
	}

	@Autowired
	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}

	@RequestMapping(value = "/{projectCode}", method = RequestMethod.GET)
	public ModelAndView getCommonPage(@PathVariable String projectCode) {
		logger.debug("Received request to show content main page");
		TagVO tag = contentService.getTagByName(projectCode, SpecialTag.MAIN_PAGE_TAG.getName());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tag", tag);
		map.put("projectCode", projectCode);
		return new ModelAndView("view/index", map);
	}

	@RequestMapping(value = "/{projectCode}/home", method = RequestMethod.GET)
	public ModelAndView getHomePage(@PathVariable String projectCode) {
		logger.debug("Received request to show content main page");
		TagVO tag = contentService.getTagByName(projectCode, SpecialTag.MAIN_PAGE_TAG.getName());
		ProjectVO project = projectService.findByCode(projectCode);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("project", project);
		return new ModelAndView("view/home/projectDesc", map);
	}

	@RequestMapping(value = "/{projectCode}/content", method = RequestMethod.GET)
	public ModelAndView getContentPage(@PathVariable String projectCode) {
		logger.debug("Received request to show content main page");
		TagVO tag = contentService.getTagByName(projectCode, SpecialTag.MAIN_PAGE_TAG.getName());
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tag", tag);
		map.put("projectCode", projectCode);
		return new ModelAndView("view/contentView/contentView", map);
	}

	@RequestMapping(value = "/{projectCode}/tag/{tagName}/subTagList")
	public ModelAndView getSubTagListByTagName(@PathVariable String projectCode, @PathVariable String tagName) {
		logger.debug("Received request to show tag detail page");
		TagVO tag = contentService.getTagByName(projectCode, tagName);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tagName", tagName);
		map.put("tagList", tag.getTaggedTags());
		map.put("projectCode", projectCode);
		return new ModelAndView("view/contentView/subTagList", map);
	}

	@RequestMapping(value = "/{projectCode}/tag/{tagName}/contentList")
	public ModelAndView getContentListByTagName(@PathVariable String projectCode, @PathVariable String tagName) {
		logger.debug("Received request to show tag detail page");
		TagVO tag = contentService.getTagByName(projectCode, tagName);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("tagName", tagName);
		map.put("contentList", tag.getTaggedContents());
		map.put("projectCode", projectCode);
		return new ModelAndView("view/contentView/contentList", map);
	}

	@RequestMapping(value = "/{projectCode}/content/{contentCode}", method = RequestMethod.GET)
	public ModelAndView getContentByCode(@PathVariable String projectCode, @PathVariable String contentCode) {
		logger.debug("Received request to show content detail page");
		ContentVO content = contentService.getContentByCode(projectCode, contentCode);
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("content", content);
		map.put("projectCode", projectCode);
		return new ModelAndView("view/contentView/contentDetail", map);
	}
}
