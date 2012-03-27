package gotocameraOld;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StandaloneDBRW {
    private static final ApplicationContext ac= 
        new ClassPathXmlApplicationContext("beans.xml");
    protected final Log logger = LogFactory.getLog(getClass());
	public static void main(String[] args) {
		StandaloneDBRW dbRW = new StandaloneDBRW();
		dbRW.run();
    }
	private void run() {
		CategoryDao testCategoryDao = new CategorySpringJdbcDao(ac);
		List<Category> list = testCategoryDao.getAllCategory();
		logger.debug(list.size());
    }
}