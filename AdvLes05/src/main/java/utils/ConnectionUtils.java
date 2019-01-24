package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
		private static String USER_NAME= "root";
		private static String USER_PASSWORD = "root";
		private static String url = "jdbc:mysql://localhost/magazines?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		
		public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
			Class.forName ("com.mysql.cj.jdbc.Driver").newInstance ();
			return DriverManager.getConnection (url, USER_NAME, USER_PASSWORD);
			
			
		}

}
