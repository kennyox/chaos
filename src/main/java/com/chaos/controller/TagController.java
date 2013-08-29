package com.chaos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chaos.service.TagAJAXService;
import com.chaos.vo.TagVO;

@Controller
@RequestMapping("/tag")
public class TagController extends GenericController {

	@Autowired
	protected TagAJAXService tagAJAXService;

	
	/**
	 * Handles and retrieves the main page that everyone can see
	 * 
	 * @return the name of the ftl page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public @ResponseBody List<TagVO> getAllTag() {
		logger.debug("Received get all tag");
		return tagAJAXService.getAllTag();
	}

}
