package factory;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionFactory {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "My@123456%SQL";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/hotelalura?useTimezone=true&serverTimezone=UTC";
	
	public static Connection createConnection() throws SQLException, ClassNotFoundException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setJdbcUrl(DATABASE_URL);
		cpds.setUser(USERNAME);
		cpds.setPassword(PASSWORD);	
		return cpds.getConnection();
	}
}