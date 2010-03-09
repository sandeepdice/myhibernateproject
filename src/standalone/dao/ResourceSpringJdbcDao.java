package standalone.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;
import org.xml.sax.InputSource;

import standalone.beans.Resource;

public class ResourceSpringJdbcDao extends SimpleJdbcDaoSupport implements ResourceDao {

	private LobHandler lobHandler;
	
	private static final String RES_INSERT = "INSERT INTO au_resource (resourceId, file_Content)" +
//			", resourceType, fileContent) " +
	"values (?, ?)";
	
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}
	
	private static final String GET_NEXT_RES_ID = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name='au_resource'";

	@Override
	public int insertResource(final Resource res) {
		// TODO Auto-generated method stub
		System.out.println("Inserting resource");
		System.out.println("File content: "+ res.getFileContent());
		getJdbcTemplate().execute(
				RES_INSERT,
				new AbstractLobCreatingPreparedStatementCallback(this.lobHandler) {
					protected void setValues(PreparedStatement ps, LobCreator lobCreator) throws SQLException {
						ps.setNull(1, java.sql.Types.INTEGER);
						lobCreator.setBlobAsBytes(ps, 2, res.getFileContent());
//						ps.setString(2, res.getResourceName());
//						ps.setString(3, res.getResourceType());
					}
				}
		);
		return getJdbcTemplate().queryForInt( "select last_insert_id()" );
	}

}
