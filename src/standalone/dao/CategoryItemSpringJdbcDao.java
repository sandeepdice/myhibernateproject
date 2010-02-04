package standalone.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import standalone.beans.Category;
import standalone.beans.Item;

public class CategoryItemSpringJdbcDao extends SimpleJdbcDaoSupport implements CategoryItemDao{

	public static final String GET_SUB_CATEGORIES = "select * from au_category where parentcategoryId=?";
	public static final String GET_ITEMS_OF_CATEGORY = "select * from au_items where categoryId=?";
	@Override
	public Map<String, List<?>> getCategoryDetails(long categoryId) {
		// TODO Auto-generated method stub
		
		Map<String, List<?>> result = new HashMap();
		List<Category> categoryList = getJdbcTemplate().query(GET_SUB_CATEGORIES,
				new Object[] { Long.valueOf(categoryId) },
				new RowMapper() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException
				{	Category category = new Category();
					category.setCategoryId(rs.getLong(1));
					category.setCategoryName(rs.getString(2));
					category.setDescription(rs.getString(3));
					category.setParentCategoryId(rs.getLong(4));
					return category;
				}
					});
		System.out.println("Setting categoryList");
		System.out.println("Setting categoryList size: " + categoryList.size());
		result.put("category", categoryList);
		
		List<Item> itemsList = getJdbcTemplate().query(GET_ITEMS_OF_CATEGORY,
				new Object[] { Long.valueOf(categoryId) },
				new RowMapper() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException
				{	Item item = new Item();
					item.setItemId(rs.getLong(1));
					item.setCategoryId(rs.getLong(2));
					item.setDisplayName(rs.getString(3));
					item.setDescription(rs.getString(4));
					item.setPrice(rs.getDouble(5));
					item.setPriceCurrency(rs.getString(6));
					item.setSellerId(rs.getString(7));
					item.setOriginCountry(rs.getString(8));
					return item;
				}
					});
		result.put("items", itemsList);
		System.out.println("Setting itemList");
		System.out.println("Setting itemList size: " + itemsList.size());		
		return result;
	}
	
	public CategoryItemSpringJdbcDao() {
		
	}
}
