package management;

import java.sql.*;

public class CreateConnection {

	private static String url = "jdbc:mysql://localhost:3306/QuizzDB";
	private static String username = "root";
	private static String password = "pradeep1212";

	public static Connection create() {
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
