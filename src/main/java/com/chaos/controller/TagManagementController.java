package com.chaos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.chaos.service.ContentManagementAJAXService;
import com.chaos.service.ContentManagementService;
import com.chaos.vo.TagVO;
import com.chaos.vo.UserDetails;

@Controller
@RequestMapping("/admin/tag")
public class TagManagementController extends GenericController {

	private ContentManagementService contentService;
	private ContentManagementAJAXService contentAJAXService;

	@Autowired
	public void setContentService(ContentManagementService contentService) {
		this.contentService = contentService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView rootPageContent() {
		return new ModelAndView("admin/tag/tagsList", "tags", getContentPage());
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView rootPage2Content() {
		return new ModelAndView("admin/tag/tagsList", "tags", getContentPage());
	}

	private List<TagVO> getContentPage() {
		logger.debug("Received request to show all tag");
		List<TagVO> tags = null;
		UserDetails user = getUser();
		if (user != null) {
			tags = contentService.getAllTag(user.getProjectCode());
		}
		return tags;
	}

	@RequestMapping(value = "/{tagName}", method = RequestMethod.GET)
	public ModelAndView getTag(@PathVariable String tagName) {
		return new ModelAndView("admin/tag/tagDetail", "tag", getTagByName(tagName));
	}

	protected TagVO getTagByName(String tagName) {
		TagVO newTag = null;
		UserDetails user = getUser();
		if (user != null) {
			newTag = contentService.getTagByName(user.getProjectCode(), tagName,true);
		}
		return newTag;
	}

	// AJAX call
	@RequestMapping(value = "/JSON", method = RequestMethod.GET)
	public @ResponseBody
	List<TagVO> rootPageIgnoredContent() {
		return getContentPage();
	}

	@RequestMapping(value = "/{tagName}:JSON", method = RequestMethod.GET)
	public @ResponseBody
	TagVO getTagJSON(@PathVariable String tagName) {

		return getTagByName(tagName);
	}

	@RequestMapping(value = "/{sourceTagName}/tagging/{targetTagName}", method = RequestMethod.GET)
	public @ResponseBody
	TagVO taggingATag(@PathVariable String sourceTagName, @PathVariable String targetTagName) {
		TagVO newTag = null;
		UserDetails user = getUser();
		if (user != null) {
			newTag = contentAJAXService.taggingATag(user.getProjectCode(), sourceTagName, targetTagName);
		}
		return newTag;
	}
	
	@RequestMapping(value = "/{tagName}/update")
	public @ResponseBody
	TagVO tagUpdate(@PathVariable String tagName, @RequestParam("description") String description, @RequestParam("taggedByTags") String taggedByTags) {
		TagVO tag = null;
		UserDetails user = getUser();
		if (user != null) {
			String[] taggedByTagNameList = taggedByTags.split("\\s");
			tag = contentService.updateTag(user.getProjectCode(), tagName, description, taggedByTagNameList);
		}
		return tag;
	}

}
