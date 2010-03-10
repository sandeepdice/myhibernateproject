package standalone.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.jdbc.core.support.AbstractLobCreatingPreparedStatementCallback;
import org.springframework.jdbc.support.lob.LobCreator;
import org.springframework.jdbc.support.lob.LobHandler;

import standalone.beans.Resource;

public class ResourceSpringJdbcDao extends SimpleJdbcDaoSupport implements ResourceDao {

	private LobHandler lobHandler;
	
	private static final String RES_INSERT = "INSERT INTO au_resource (resourceId, file_Content" +
			", resourceType, resourceName) " +
	"values (?, ?, ?, ?)";
	
	public void setLobHandler(LobHandler lobHandler) {
		this.lobHandler = lobHandler;
	}
	
	private static final String GET_NEXT_RES_ID = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name='au_resource'";
	private static final String GET_BYTE_STREAM = "select file_content from au_resource where resourceId = ?";

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
						ps.setString(3, res.getResourceName());
						ps.setString(4, res.getResourceType());
					}
				}
		);
		return getJdbcTemplate().queryForInt( "select last_insert_id()" );
	}
	
	@Override
	public byte[] getResource(String resourceId) {
		System.out.println("resourceId received for db retrieval: *" + resourceId+"*");
		Connection con;
		byte[] resultArray = null;
		try {
			System.out.println("Line 1");
			con = getJdbcTemplate().getDataSource().getConnection();
			System.out.println("Line 2");
			PreparedStatement ps = con.prepareStatement(GET_BYTE_STREAM);
			System.out.println("Line 3");
			ps.setInt(1, Integer.parseInt(resourceId));
			System.out.println("Line 4");
			ResultSet rs = ps.executeQuery();
			System.out.println("Executed query ");
			
			while(rs.next())
			{
				System.out.println("executing query... ");
				resultArray = rs.getBytes("file_content");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		List<Blob> packetList = getJdbcTemplate().query(GET_BYTE_STREAM, new Object[] {resourceId}, new RowMapper() {
//			
//			@Override
//			public Object mapRow(ResultSet arg0, int arg1) throws SQLException {
//				System.out.println("blob length: "+arg0.getBlob("file_content").length());
//				return arg0.getBlob("file_source");
//			}
//		});
//
//		try {
//			resultArray =  packetList.get(0).getBytes(0, (int)packetList.get(0).length());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return resultArray;
	}
	
	public ResourceSpringJdbcDao(JdbcTemplate template) {
		// TODO Auto-generated constructor stub
		this.setJdbcTemplate(template);
	}
	
	public ResourceSpringJdbcDao() {
		// TODO Auto-generated constructor stub
	}

}