package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection getConnection() {
		Connection c = null;

		try {
			// dang ki mysql  drive vs drivemanager
			DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
			String url  = "jdbc:mySQL://localhost:3306/ontap";
			String username = "root";
			String password = "";
			
			// tao ket noi
			c = DriverManager.getConnection(url,username,password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void closeConnection(Connection c) {

		try {
			
			if(c != null)
			{
				c.close(); 
			}
			else 
			{
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
