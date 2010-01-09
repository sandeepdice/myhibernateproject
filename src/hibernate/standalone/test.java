package hibernate.standalone;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.commons.dbcp.BasicDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class test {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("META-INF/beans.xml");
	public static void main(String[] args) {
		testClass bean= (testClass) ac.getBean("testClassObj");
        System.out.println("Retrieved string: " + bean.getMyString());      
        TestDao testDao = new TestDao();
        testDao.setJdbcTemplate((JdbcTemplate)ac.getBean("jdbcTemplate"));
        Category result = testDao.getCategory(100);
        System.out.println("Retrieved value: " + result.getCategoryId());
    }
}

class testClass
{
	private String myString;

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}
}

class TestDao extends SimpleJdbcDaoSupport
{
	
	private static final String MOTORIST_SELECT =
		"select categoryId from au_category";
		private static final String MOTORIST_BY_ID_SELECT =
		MOTORIST_SELECT + " where categoryId=?";
	public Category getCategory(long id)
	{
		System.out.println("in getCategory");
			List matches = getJdbcTemplate().query(MOTORIST_BY_ID_SELECT,
			new Object[] { Long.valueOf(id) },
			new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException
			 {
				
				Category category = new Category();
				category.setCategoryId(rs.getLong(1));
				return category;
				}
				});
			System.out.println("exiting getCategory");
			return matches.size() > 0 ? (Category) matches.get(0) : null;
	}
}

class Category
{
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public long getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(long categoryName) {
		this.categoryName = categoryName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	long categoryId;
	long categoryName;
	String description;	
}