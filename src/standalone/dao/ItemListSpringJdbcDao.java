package standalone.dao;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import standalone.beans.Item;

public class ItemListSpringJdbcDao extends SimpleJdbcDaoSupport implements ItemListDao{
	protected final Log logger = LogFactory.getLog(getClass());
	
	private static final String ITEM_LIST = "select itemId, displayName, price, resourceId from au_items";
	
	public ItemListSpringJdbcDao()
	{
		
	}
	public ItemListSpringJdbcDao(ApplicationContext ac)
	{
		this.setJdbcTemplate((JdbcTemplate)ac.getBean("jdbcTemplate"));
	}

	@Override
	public List<Item> getItemList() {
		// TODO Auto-generated method stub
		
		List<Item> itemList = getJdbcTemplate().query(ITEM_LIST,
				new Object[] { },
				new RowMapper() {
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException
				{	Item category = new Item();
					category.setItemId(rs.getLong(1));
					category.setDisplayName(rs.getString(2));
					category.setPrice(rs.getLong(3));
					category.setResourceId(rs.getString(4));
					return category;
				}
					});
		return itemList;
	}
}