package com.roadrantz.mvc;

import hibernatebook.ch01.UserInfo;
import hibernatebook.ch01.dao.HibernateEmployeeDao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;

import com.roadrantz.dao.CategoryDao;
import com.roadrantz.dao.ItemDao;
import com.roadrantz.dao.ResourceDao;

import standalone.beans.Category;
import standalone.beans.Item;

public class AddEmployeeController extends SimpleFormController {
	public AddEmployeeController() {
		setCommandClass(UserInfo.class);
	}
	
	private HibernateEmployeeDao hibernateEmployeeDao;

	public void setHibernateEmployeeDao(HibernateEmployeeDao hibernateEmployeeDao) {
	this.hibernateEmployeeDao = hibernateEmployeeDao;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {		
		UserInfo item = (UserInfo) command;
		hibernateEmployeeDao.addUser(item);
		return new ModelAndView(getSuccessView());
	}
}
