package standalone.dao;

import java.util.ArrayList;
import java.util.List;

import standalone.beans.Category;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public interface CategoryDao {
	final int BATCH_INSERT_SIZE = 100;
	Category getCategory(long id, String categoryName);
	int addCategory(long id, String categoryName, String description);
	int deleteCategory(long id);
	int deleteAll();
	void batchInsert();
	void batchInsertInLoop();
	List<Category> getAllCategory();
}