package standalone.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

import standalone.beans.Category;

public class CategoryJdbcDao extends SimpleJdbcDaoSupport implements CategoryDao{
	private static final String MOTORIST_SELECT =
		"select categoryId from au_category";
		private static final String MOTORIST_BY_ID_SELECT =
		MOTORIST_SELECT + " where categoryId=? and categoryName=?";
	public Category getCategory(long id, String categoryName)
	{
		System.out.println("in getCategory");
			List matches = getJdbcTemplate().query(MOTORIST_BY_ID_SELECT,
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
}