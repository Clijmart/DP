package P3.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleBaseDao {
	private static final String DB_DRIV = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DB_USER = "mart2";
	private static final String DB_PASS = "mart2";
	private static Connection conn;
	
	public OracleBaseDao() throws SQLException {
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
	}
	
	protected static Connection getConnection() {
		return conn;
	}
	
	public void closeConnection() throws SQLException {
		conn.close();
	}
}
