package standalone.dao;

import standalone.beans.Category;

interface CategoryDao {
	public Category getCategory(long id, String categoryName);
}