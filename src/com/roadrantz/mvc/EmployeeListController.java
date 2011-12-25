package com.roadrantz.mvc;

import hibernatebook.ch01.UserInfo;
import hibernatebook.ch01.dao.HibernateEmployeeDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.roadrantz.dao.CategoryDao;
import com.roadrantz.dao.ItemDao;
import com.roadrantz.dao.ItemListDao;

import standalone.beans.Category;
import standalone.beans.Item;

public class EmployeeListController extends SimpleFormController {
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		UserInfo item = (UserInfo) command;
		List itemList = hibernateEmployeeDao.getUser(item.getFirstName());
		return new ModelAndView("employeeList", "employeeList", itemList);
	}
	
	public EmployeeListController() {
		setCommandClass(UserInfo.class);
	}
	
	HibernateEmployeeDao hibernateEmployeeDao;

	public HibernateEmployeeDao getHibernateEmployeeDao() {
		return hibernateEmployeeDao;
	}

	public void setHibernateEmployeeDao(HibernateEmployeeDao itemListDao) {
		this.hibernateEmployeeDao = itemListDao;
	}
	
}
