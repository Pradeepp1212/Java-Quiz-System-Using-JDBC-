package management;

import java.sql.*;

public class QuizDAO {

	// display questions
	public static String[] displayQuestions_og() throws SQLException {
		String arr[] = new String[10];

		String query = "SELECT question FROM keybook";
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
		rs.next();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rs.getString(1);
			rs.next();
		}

		return arr;

	}

	public static void getchoices(int idc) throws SQLException {
		String query = "SELECT option_a ,option_b ,option_c ,option_d from keybook where id=" + idc;
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
		rs.next();
		System.out.println("A) " + rs.getString(1));
		System.out.println("B) " + rs.getString(2));
		System.out.println("C) " + rs.getString(3));
		System.out.println("D) " + rs.getString(4));

	}

	public static int checkScore(char[] ans) throws SQLException {
		int Score = 0;

		String query = "select ans from keybook";
		Connection con = CreateConnection.create();
		Statement st = con.createStatement();

		ResultSet rs = st.executeQuery(query);
		rs.next();

		for (int i = 0; i < ans.length; i++) {
			String ch = ans[i] + "";
			String right_ans = rs.getString(1);

			if (right_ans.equalsIgnoreCase(ch)) {
				Score++;
			}
			rs.next();

		}
		return Score;

	}

}
