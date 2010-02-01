package com.roadrantz.mvc;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import standalone.beans.User;
import standalone.dao.CategoryDao;

public class GetCategoryController extends AbstractController {
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String categoryId = request.getParameter("categoryId");
		List categoryList = categoryDao.getItemsByCategoryId(categoryId);
		logger.info("Processing HomePageController request");
		return new ModelAndView("itemsByCategory", "categoryList", categoryList);
	}
	
	private CategoryDao categoryDao;
	public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
	}		
}
