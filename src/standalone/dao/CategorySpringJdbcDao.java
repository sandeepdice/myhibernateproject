package standalone.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.context.ApplicationContext;

import standalone.beans.Category;

public class CategorySpringJdbcDao extends SimpleJdbcDaoSupport implements CategoryDao{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final String CATEGORY_SELECT = "select categoryId from au_category";
	private static final String CATEGORY_BY_ID_SELECT = CATEGORY_SELECT + " where categoryId=? and categoryName=?";
	private static final String CATEGORY_INSERT = "insert into au_category values (?, ?, ?, ?)";
	private static final String CATEGORY_DELETE = "delete from au_category where categoryId = ?";
	private static final String CATEGORY_DELETE_ALL = "delete from au_category";
	private static final String CATEGORY_GET_ALL = "select * from au_category";
	
	public CategorySpringJdbcDao()
	{
		
	}
	public CategorySpringJdbcDao(ApplicationContext ac)
	{
		this.setJdbcTemplate((JdbcTemplate)ac.getBean("jdbcTemplate"));
	}
	@Override
	public Category getCategory(long id, String categoryName)
	{
			logger.debug("in getCategory");
			List matches = getJdbcTemplate().query(CATEGORY_BY_ID_SELECT,
			new Object[] { Long.valueOf(id), categoryName },
			new RowMapper() {
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException
			{	Category category = new Category();
				category.setCategoryId(rs.getLong(1));
				return category;
			}
				});
			logger.debug("exiting getCategory");
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
	@Override
	public void batchInsert() {
		List<List> parsedFile = parseFile("resources/category.data");
		final List categoryIdList = parsedFile.get(0);
		final List categoryNameList = parsedFile.get(1);
		final List categoryDescriptionList = parsedFile.get(2);
		final List parentCategoryIdList = parsedFile.get(3);
		int[] rowsAffected = getJdbcTemplate().batchUpdate(CATEGORY_INSERT, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement arg0, int arg1) throws SQLException {
				arg0.setInt(1, Integer.parseInt((String)categoryIdList.get(arg1)));
				arg0.setString(2, (String)categoryNameList.get(arg1));
				arg0.setString(3, (String)categoryDescriptionList.get(arg1));
				arg0.setInt(4, Integer.parseInt((String)parentCategoryIdList.get(arg1)));
			}
			
			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return categoryIdList.size();
			}
		});
	}
	@Override
	public void batchInsertInLoop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		logger.debug("in getCategory");
		List<Category> matches = getJdbcTemplate().query(CATEGORY_GET_ALL,
		new Object[] {  },
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
		logger.debug("exiting getCategory");
		return matches;
	}
	List<List> parseFile(String fileName) {
		String nextLine;
		List resultList = new ArrayList(4);
		List categoryIdList = new ArrayList<Integer>();
		List categoryNameList = new ArrayList<String>();
		List categoryDescriptionList = new ArrayList<String>();
		List parentCategoryIdList = new ArrayList<Integer>();
		try {
			InputStream stream = new FileInputStream(fileName);
			Scanner scanner = new Scanner(stream);
			while(scanner.hasNextLine())
			{
				nextLine = scanner.nextLine();
				if(!nextLine.trim().isEmpty())
				{
					StringTokenizer tokenizer = new StringTokenizer(nextLine, ",");
					categoryIdList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
					categoryNameList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
					categoryDescriptionList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
//					System.out.println(tokenizer.nextToken());
					parentCategoryIdList.add(tokenizer.hasMoreTokens()?tokenizer.nextToken():null);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resultList.add(categoryIdList);
		resultList.add(categoryNameList);
		resultList.add(categoryDescriptionList);
		resultList.add(parentCategoryIdList);
		return resultList;
	}
	
	@Override
	public List<Category> getItemsByCategoryId(String categoryId)
	{
		logger.debug("in getCategory");
		List<Category> matches = getJdbcTemplate().query(CATEGORY_GET_ALL+" where parentcategoryId=? ",
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
		logger.debug("exiting getCategory");
		return matches;		
	}
}