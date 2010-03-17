package com.roadrantz.mvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


import com.roadrantz.dao.CategoryDao;
import com.roadrantz.service.RantService;

public class HomePageController extends AbstractController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	public HomePageController() {}
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List categoryList = categoryDao.getAllCategory();
		logger.info("Processing HomePageController request");
		return new ModelAndView("home", "rants", categoryList);
	}
	private RantService rantService;
	public void setRantService(RantService rantService) {
	this.rantService = rantService;
	}
	
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
	}	
}
