package standalone.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import standalone.beans.Category;

public class CategoryJdbcDao extends CategoryDao{
	private static final String CATEGORY_SELECT = "select categoryId from au_category";
	private static final String CATEGORY_BY_ID_SELECT = CATEGORY_SELECT + " where categoryId=? and categoryName=?";
	private static final String CATEGORY_INSERT = "insert into au_category values (?, ?, ?)";
	private static final String CATEGORY_DELETE = "delete from au_category where categoryId = ?";
	private static final String CATEGORY_DELETE_ALL = "delete from au_category";
	@Override
	public Category getCategory(long id, String categoryName)
	{
		System.out.println("in getCategory");
			List matches = getJdbcTemplate().query(CATEGORY_BY_ID_SELECT,
			new Object[] { Long.valueOf(id), categoryName },
			new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException
			{	Category category = new Category();
				category.setCategoryId(rs.getLong(1));
				return category;
			}
				});
			System.out.println("exiting getCategory");
			return matches.size() > 0 ? (Category) matches.get(0) : null;
	}
	@Override
	public int addCategory(long id, String categoryName, String description) {
		// TODO Auto-generated method stub
		int rowsAffected = getJdbcTemplate().update(CATEGORY_INSERT, new Object[] {Long.valueOf(id), categoryName, description});
		return rowsAffected;
	}
	
	@Override
	public int deleteCategory(long id) {
		int rowsAffected = getJdbcTemplate().update(CATEGORY_DELETE, new Object[] {Long.valueOf(id)});
		return rowsAffected;
	}
	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		int rowsAffected = getJdbcTemplate().update(CATEGORY_DELETE_ALL);
		return rowsAffected;
	}
}