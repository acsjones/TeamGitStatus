package co.grandcircus.vitamenu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Provides connections to a MySQL database.
 */
@Component
public class JdbcConnectionFactory {
	
	private static final Logger logger = LoggerFactory.getLogger(JdbcConnectionFactory.class);
	
	private String driverClass = "com.mysql.jdbc.Driver";
	

		@Value("jdbc:mysql://localhost:3307/vitamenu")
	private String dbUrl;
	
	@Value("root")
	private String username;
	
	@Value("pranavi")
    private String password;
	
	public Connection getConnection() {
		try {
			boolean passwordPresent = password != null & !password.isEmpty();
			logger.info("DB Connection. url:" + dbUrl + " user:" + username + "password:" + ( passwordPresent ? "present" : "ABSENT!" ));
			
			Class.forName(driverClass); 
		    return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException | ClassNotFoundException ex) {
		    throw new RuntimeException("Connection Failure", ex);
		}
	}

}
