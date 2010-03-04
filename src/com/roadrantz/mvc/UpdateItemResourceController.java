package com.roadrantz.mvc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import standalone.beans.Category;
import standalone.beans.AddItem;
import standalone.beans.Item;
import standalone.dao.CategoryDao;
import standalone.dao.ItemDao;

public class UpdateItemResourceController extends SimpleFormController {
	private static final String[] ALL_STATES = {
		"AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "DC", "FL",
		"GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME",
		"MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH",
		"NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
		"SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WV", "WI",
		"WY"
		};
	public UpdateItemResourceController() {
		setCommandClass(AddItem.class);
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request)
	{
		System.out.println("in referenceData UpdateItemResouceController");
		Map referenceData = new HashMap();
		referenceData.put("itemIdFromSuccessView", request.getParameter("itemIdFromSuccessView"));
		System.out.println("itemId received:" + request.getParameter("itemIdFromSuccessView"));
		return referenceData;
	}
	
	private CategoryDao categoryDao;
	private ItemDao itemDao;
	public void setCategoryDao(CategoryDao categoryDao) {
	this.categoryDao = categoryDao;
	}
	
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		// TODO Auto-generated method stub
		AddItem item = (AddItem) command;
		String resourceId = request.getParameter("resourceId");
		String itemId = request.getParameter("itemId");
		item.setResourceId(resourceId);
		item.setItemId(Integer.parseInt(itemId));
		return new ModelAndView(getSuccessView());
	}
}
