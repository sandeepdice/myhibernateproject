package com.roadrantz.mvc;

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

public class ItemListController extends AbstractController {
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)throws Exception {
		List itemList = itemListDao.getItemList();
//		logger.info("Processing HomePageController request");
		return new ModelAndView("itemList", "itemList", itemList);
	}
	
	ItemListDao itemListDao;

	public ItemListDao getItemListDao() {
		return itemListDao;
	}

	public void setItemListDao(ItemListDao itemListDao) {
		this.itemListDao = itemListDao;
	}
	
}
