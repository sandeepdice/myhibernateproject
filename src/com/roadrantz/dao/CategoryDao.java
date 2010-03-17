package com.roadrantz.dao;

import java.util.List;

import standalone.beans.Category;

public interface CategoryDao {
	final int BATCH_INSERT_SIZE = 100;
	Category getCategory(long id, String categoryName);
	int addCategory(long id, String categoryName, String description);
	int deleteCategory(long id);
	int deleteAll();
	void batchInsert();
	void batchInsertInLoop();
	List<Category> getAllCategory();
	List<Category> getItemsByCategoryId(String categoryId);
	List<Category> getAllSubCategories();
}