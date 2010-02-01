package standalone.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import standalone.beans.Category;

public class CategoryPlainJdbcDao implements CategoryDao {

	java.util.Properties dbProperties;
	String url, username, password, className;

	public CategoryPlainJdbcDao()
	{
		dbProperties = new Properties();
		try {
			dbProperties.load(new FileInputStream("resources/jdbc.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		url = dbProperties.getProperty("jdbc.url");
		username = dbProperties.getProperty("jdbc.username");
		password = dbProperties.getProperty("jdbc.password");
		className = dbProperties.getProperty("jdbc.driverClassName");
		
		try {
			Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public int addCategory(long id, String categoryName, String description) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void batchInsert() {
		
		try {

			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("insert into au_category values (?, ?, ?, ?)");
			for(int i=0;i<BATCH_INSERT_SIZE; i++)
			{
				ps.setInt(1, i);
				ps.setString(2, "categoryName");
				ps.setString(3, "descriptionName");
				ps.setInt(4, 0);
				
				ps.addBatch();
			}
			
			System.out.println("in executeBatch:" + new Date(System.currentTimeMillis()));
			int[] result = ps.executeBatch();
			System.out.println(new Date(System.currentTimeMillis()));
			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = conn.prepareStatement("delete from au_category");		
			System.out.println("deleteAll:" +new Date(System.currentTimeMillis()));
			result = ps.execute();
			System.out.println(new Date(System.currentTimeMillis()));
			ps.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result==false?0:1;
	}
	
	public void batchInsertInLoop()
	{
		try {

			Connection conn = DriverManager.getConnection(url, username, password);
			
			System.out.println("executing preparedStatement 100 times in loop:" + new Date(System.currentTimeMillis()));
			for(int i=0;i<BATCH_INSERT_SIZE; i++)
			{
				PreparedStatement ps = conn.prepareStatement("insert into au_category values (?, ?, ?, ?)");
				ps.setInt(1, i);
				ps.setString(2, "categoryName");
				ps.setString(3, "descriptionName");
				ps.setInt(4, 0);
				
				ps.execute();
				ps.close();
			}
			System.out.println(new Date(System.currentTimeMillis()));
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int deleteCategory(long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Category getCategory(long id, String categoryName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Category> getItemsByCategoryId(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

}
