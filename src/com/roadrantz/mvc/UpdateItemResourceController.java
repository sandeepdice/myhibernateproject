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
//		setCommandName("Patient");
		setCommandClass(AddItem.class);
//		setCommandClass(Item.class);
//		setSessionForm(true);
	}
///*
	protected void doSubmitAction(Object command) {
		AddItem item = (AddItem) command;
		
		System.out.println("in doSubmitAction");
		System.out.println("category id: "+item.getCategoryId());
		System.out.println("display name: "+item.getDisplayName()); 
		System.out.println("description : "+item.getDescription());
		System.out.println("price : "+item.getPrice());
		System.out.println("currency: "+item.getPriceCurrency());		
		itemDao.insertItem(item);		
		System.out.println("finished doSubmitAction");
//		throw new NullPointerException();
	}
//	*/
	
	@Override
	protected Map referenceData(HttpServletRequest request)
	{
		System.out.println("in referenceData");
		Map referenceData = new HashMap();
		referenceData.put("states", ALL_STATES);
		
		List<Category> categoryList = categoryDao.getAllSubCategories();
		referenceData.put("categoryList", categoryList);
		
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
