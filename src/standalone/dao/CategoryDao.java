package standalone.dao;

import standalone.beans.Category;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public abstract class CategoryDao extends SimpleJdbcDaoSupport{
	public abstract Category getCategory(long id, String categoryName);
	public abstract int addCategory(long id, String categoryName, String description);
	public abstract int deleteCategory(long id);
	public abstract int deleteAll();
}