package com.roadrantz.mvc;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import standalone.dao.CategoryDao;

import com.roadrantz.service.RantService;

public class HomePageController extends AbstractController {
	public HomePageController() {}
	protected ModelAndView handleRequestInternal(
	HttpServletRequest request, HttpServletResponse response)
	throws Exception {
	
	List categoryList = categoryDao.getAllCategory();
	
	return new ModelAndView("home",
			"rants", categoryList);
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
