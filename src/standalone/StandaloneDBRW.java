package standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import standalone.beans.Category;
import standalone.dao.CategoryJdbcDao;

public class StandaloneDBRW {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("META-INF/beans.xml");
	public static void main(String[] args) {
        CategoryJdbcDao testDao = new CategoryJdbcDao();
        testDao.setJdbcTemplate((JdbcTemplate)ac.getBean("jdbcTemplate"));
        Category result = testDao.getCategory(100, "category1");
        System.out.println("Retrieved value: " + result.getCategoryId());
    }
}