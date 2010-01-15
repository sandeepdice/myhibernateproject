package standalone.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.context.ApplicationContext;

import standalone.beans.Category;

public class CategorySpringJdbcDao extends SimpleJdbcDaoSupport implements CategoryDao{
	private static final String CATEGORY_SELECT = "select categoryId from au_category";
	private static final String CATEGORY_BY_ID_SELECT = CATEGORY_SELECT + " where categoryId=? and categoryName=?";
	private static final String CATEGORY_INSERT = "insert into au_category values (?, ?, ?)";
	private static final String CATEGORY_DELETE = "delete from au_category where categoryId = ?";
	private static final String CATEGORY_DELETE_ALL = "delete from au_category";
	private static final String CATEGORY_GET_ALL = "select * from au_category";
	
	public CategorySpringJdbcDao(ApplicationContext ac)
	{
		this.setJdbcTemplate((JdbcTemplate)ac.getBean("jdbcTemplate"));
	}
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
	@Override
	public void batchInsert() {
		List<List> parsedFile = parseFile("resources/category.data");
		// TODO Auto-generated method stub
	}
	@Override
	public void batchInsertInLoop() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ArrayList<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	private List<List> parseFile(String fileName) {
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
					categoryIdList.add(new Integer(tokenizer.nextToken()));
					categoryNameList.add(tokenizer.nextToken());
					categoryDescriptionList.add(tokenizer.nextToken());
					parentCategoryIdList.add(new Integer(tokenizer.nextToken()));
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
}