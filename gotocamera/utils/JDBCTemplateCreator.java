package utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateCreator {
	JdbcTemplate jdbcTemplate;
	BasicDataSource myDataSource;
	static JDBCTemplateCreator templateCreator;

	private JDBCTemplateCreator() {
	}

	public static JdbcTemplate getInstance(String userName, String password,
			String url, String driverClassName) {
		if (templateCreator == null) {
			
			templateCreator = new JDBCTemplateCreator();
			templateCreator.myDataSource = new BasicDataSource();
			templateCreator.myDataSource.setUsername(userName);
			templateCreator.myDataSource.setUrl(url);
			templateCreator.myDataSource.setPassword(password);
			templateCreator.myDataSource.setDriverClassName(driverClassName);

			templateCreator.jdbcTemplate = new JdbcTemplate(templateCreator.myDataSource);
		}
		return templateCreator.jdbcTemplate;
	}
}