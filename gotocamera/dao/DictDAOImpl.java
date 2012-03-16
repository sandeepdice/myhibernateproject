package dao;

import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;

import utils.JDBCTemplateCreator;

import model.Term;

public class DictDAOImpl implements DictDAO {
	private static final String CATEGORY_INSERT = "insert into dict values (?, ?, ?)";
	private static final String CATEGORY_DELETE = "delete from dict where term = ?";
	private static final String CATEGORY_UPDATE = "update dict set version = ?, definition = ? where term = ?";
	JdbcTemplate jdbcTemplate;

	@Override
	public boolean checkIfTermExists(String term) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int addTerm(Term term) {
		return jdbcTemplate.update(
				CATEGORY_INSERT,
				new Object[] { term.getTerm(), term.getVersion(),
						term.getDefinition() });
	}

	@Override
	public int removeTerm(String termId) {
		int rowsAffected = jdbcTemplate.update(CATEGORY_DELETE,
				new Object[] { termId });
		return rowsAffected;
	}

	@Override
	public int updateTerm(Term term) {
		int rowsAffected = jdbcTemplate.update(CATEGORY_UPDATE, new Object[] {
				term.getVersion(), term.getDefinition(), term.getTerm() });
		return rowsAffected;
	}

	public DictDAOImpl(String userName, String password, String database)
			throws ClassNotFoundException, SQLException {
		jdbcTemplate = JDBCTemplateCreator.getInstance(userName, password,
				"jdbc:postgresql:" + database, "org.postgresql.Driver");
	}
}