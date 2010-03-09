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
	public static final String GET_ITEMS_OF_CATEGORY = "SELECT a.itemId, a.categoryId, a.displayName, a.description, a.price, a.priceCurrency, " +  
								" a.sellerId, a.originCountry, a.resourceId AS fileName " + 
								" FROM au_items a, au_resource b, au_category c " +
								" WHERE a.resourceId = b.resourceId AND a.categoryId = c.categoryId AND c.categoryId=?";
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
					item.setItemId(rs.getLong("itemId"));
					item.setCategoryId(rs.getLong("categoryId"));
					item.setDisplayName(rs.getString("displayName"));
					item.setDescription(rs.getString("description"));
					item.setPrice(rs.getDouble("price"));
					item.setPriceCurrency(rs.getString("priceCurrency"));
					item.setSellerId(rs.getString("sellerId"));
					item.setOriginCountry(rs.getString("originCountry"));
					item.setFileName(rs.getString("fileName"));
					item.setCategoryId(Integer.parseInt(rs.getString("fileName")));
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
