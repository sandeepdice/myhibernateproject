package standalone.dao;

import java.util.List;

import standalone.beans.Category;
import standalone.beans.Item;

public interface ItemDao {
	int insertItem(Item item);
	int getNextItemId();
}