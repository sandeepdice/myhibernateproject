package standalone.dao;

import java.util.List;

import standalone.beans.Category;
import standalone.beans.Item;

public interface ItemListDao {
	List<Item> getItemList();
}