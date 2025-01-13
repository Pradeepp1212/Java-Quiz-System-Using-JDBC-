package management;

import java.sql.*;

public class userDAO {

	public static void insertans(int ans, int uid) throws SQLException {
		String query = "update userdata set score=" + ans + " where uid =" + uid;
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();
		st.executeUpdate(query);

	}

	public static void insertuid(int uid) throws SQLException {
		String query = "insert into userdata(uid) values (" + uid + ")";
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();
		st.executeUpdate(query);

	}

	public static void insert_uid_name(int uid, String name) throws SQLException {
		// Prepared statements are safer and prevent SQL injection

		String query = "INSERT INTO userdata(uid, name) VALUES ('" + uid + "', '" + name + "')";
		// However, this approach is risky and can lead to SQL injection attacks if uid
		// or name contains malicious input.
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();
		st.executeUpdate(query);

	}

	public static void insertname(int id, String uname) throws SQLException {
		String query = "update userdata set name =" + uname + " where uid =" + id;
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();
		st.executeUpdate(query);

	}

	public static void insert_mail_id(int uid, String mailid) throws SQLException {
		String query = "UPDATE userdata SET mail_id = ? WHERE uid = ?";

		Connection con = CreateConnection.create();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, mailid);
		pst.setInt(2, uid);

		int row = pst.executeUpdate();
		System.out.println(row);

	}

	public static int count_data() throws SQLException {
		String query = "select count(*) from userdata";
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		int count = rs.getInt(1);

		return count;
	}

}
