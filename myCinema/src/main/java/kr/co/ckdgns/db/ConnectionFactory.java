package kr.co.ckdgns.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionFactory {
	private static String url;
	private static String user;
	private static String password;
	private static DataSource dataSource;
	static {
		ResourceBundle rb = ResourceBundle.getBundle("kr.co.ckdgns.db.dbInfo");
		String driverClassName = rb.getString("driverClassName");
			url = rb.getString("url");
			user = rb.getString("user");
			password = rb.getString("password");
			
			BasicDataSource realDS = new BasicDataSource();
			realDS.setDriverClassName(driverClassName);
			realDS.setUrl(url);
			realDS.setUsername(user);
			realDS.setPassword(password);
			realDS.setInitialSize(5);
			realDS.setMaxWaitMillis(2000);
			realDS.setMaxTotal(5);
			dataSource = realDS;
	}
	
	public static Connection getConnection() throws SQLException {
		Connection conn = dataSource.getConnection();
		return conn;
	}
}
