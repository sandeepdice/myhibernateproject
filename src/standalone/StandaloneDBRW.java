package standalone;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.roadrantz.dao.*;

import batch.BatchCategory;

import standalone.beans.Category;

public class StandaloneDBRW {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("beans.xml");
	public static void main(String[] args) {
//		JdbcTemplate jdbcTemplate = (JdbcTemplate)ac.getBean("jdbcTemplate");
		/**
		 * Category Test
		 */
		CategoryDao testCategoryDao = new CategorySpringJdbcDao(ac);
		List<Category> list = testCategoryDao.getAllCategory();
		System.out.println(list.size());
//		testCategoryDao.deleteAll();
//		testCategoryDao.batchInsert();
//		testCategoryDao.deleteAll();
//		testCategoryDao.batchInsertInLoop();
		
/*      BatchCategory batchCategory = new BatchCategory();
        batchCategory.basicTestCategory(testCategoryDao);
        batchCategory.batchTestCategory(testCategoryDao);
        */
    }
}