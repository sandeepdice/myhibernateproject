package com.roadrantz.mvc;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import standalone.beans.User;
import standalone.dao.CategoryItemDao;

public class GetCategoryItemsController extends AbstractController {
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		String categoryId = request.getParameter("categoryId");
		Map<String, List<?>> categoryItemMap = categoryItemDao.getCategoryDetails(Long.parseLong(categoryId));
		logger.info("Processing HomePageController request");
		return new ModelAndView("itemsByCategory", "categoryItemsMap", categoryItemMap);
	}
	
	private CategoryItemDao categoryItemDao;
	public void setCategoryDao(CategoryItemDao categoryItemDao) {
	this.categoryItemDao = categoryItemDao;
	}
}
