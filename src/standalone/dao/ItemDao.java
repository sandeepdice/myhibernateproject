package standalone.dao;

import java.io.IOException;
import java.util.List;

import standalone.beans.Category;
import standalone.beans.Item;

public interface ItemDao {
	int insertItem(Item item, ResourceDao resDao) throws IOException;
	int getNextItemId();
}