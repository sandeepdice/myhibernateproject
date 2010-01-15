package standalone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import batch.BatchCategory;

import standalone.beans.Category;
import standalone.dao.*;

public class StandaloneDBRW {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("META-INF/beans.xml");
	public static void main(String[] args) {
//		JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
		/**
		 * Category Test
		 */
		CategoryDao testCategoryDao = new CategorySpringJdbcDao(ac);
		testCategoryDao.deleteAll();
		testCategoryDao.batchInsert();
//		testCategoryDao.deleteAll();
//		testCategoryDao.batchInsertInLoop();
		
/*      BatchCategory batchCategory = new BatchCategory();
        batchCategory.basicTestCategory(testCategoryDao);
        batchCategory.batchTestCategory(testCategoryDao);
        */
    }
}