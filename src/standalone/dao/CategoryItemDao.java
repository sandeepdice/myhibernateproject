package standalone.dao;

import java.util.List;
import java.util.Map;

public interface CategoryItemDao {
	final int BATCH_INSERT_SIZE = 100;
	Map<String, List<?>> getCategoryDetails(long id);
}