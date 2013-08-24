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

import com.chaos.service.ContentManagementService;
import com.chaos.vo.ContentVO;
import com.chaos.vo.UserDetails;

@Controller
@RequestMapping("/admin/content")
public class ContentManagementController extends GenericController {

	private ContentManagementService contentService;

	@Autowired
	public void setContentService(ContentManagementService contentService) {
		this.contentService = contentService;
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView rootPage() {
		return new ModelAndView("admin/content/contentList", "contents", getContentsPage());
	}

	@RequestMapping(value = "/*", method = RequestMethod.GET)
	public ModelAndView rootPageIgnoredContent() {
		return new ModelAndView("admin/content/contentList", "contents", getContentsPage());
	}

	private List<ContentVO> getContentsPage() {
		List<ContentVO> contents = null;
		UserDetails user = getUser();
		if (user != null) {
			contents = contentService.getAllContent(user.getProjectCode());
		}
		return contents;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ModelAndView getContent(@PathVariable String code) {
		return new ModelAndView("admin/content/contentDetail", "content", getContentByCode(code));
	}

	private ContentVO getContentByCode(String code) {
		ContentVO newContent = null;
		UserDetails user = getUser();
		if (user != null) {
			newContent = contentService.getContentByCode(user.getProjectCode(), code);
		}
		return newContent;
	}

	@RequestMapping(value = "/{code}/update")
	public ModelAndView contentUpdate(@PathVariable String code, @RequestParam("description") String description, @RequestParam("taggedByTags") String taggedByTags) {
		ContentVO content = null;
		UserDetails user = getUser();
		if (user != null) {
			String[] taggedByTagNameList = taggedByTags.split("\\s");
			content = contentService.updateContent(user.getProjectCode(), code, description, taggedByTagNameList);
		}
		return new ModelAndView("admin/content/contentDetail", "content", content);
	}

	@RequestMapping(value = "/list/tag/{tagId}", method = RequestMethod.GET)
	public ModelAndView retrieveContentByTag(@PathVariable Integer tagId) {
		return new ModelAndView("");
	}

	@RequestMapping(value = "/createPage", method = RequestMethod.GET)
	public ModelAndView showCreatePage() {
		ContentVO content = new ContentVO();
		return new ModelAndView("admin/content/createContent", "content", content);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createContent(@RequestParam("code") String code, @RequestParam("name") String name, @RequestParam("description") String description, @RequestParam("taggedByTags") String taggedByTags) {
		ContentVO content = null;
		UserDetails user = getUser();
		if (user != null) {
			String[] taggedByTagNameList = taggedByTags.split("\\s");
			content = contentService.createContent(user.getProjectCode(), code, name, description, taggedByTagNameList);
		}
		return new ModelAndView("admin/content/contentDetail", "content", content);
	}

	// AJAX call
	@RequestMapping(value = "/{code}:JSON", method = RequestMethod.GET)
	public @ResponseBody
	ContentVO getContentJSON(@PathVariable String code) {

		return getContentByCode(code);
	}
}
