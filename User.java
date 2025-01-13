package management;

import java.sql.SQLException;

public class User {
	private int initial_uid = Integer.MAX_VALUE;

	public void addans(int score, int uid) throws SQLException {
		userDAO.insertans(score, uid);
	}

	public int count() throws SQLException {
		return userDAO.count_data();
	}

	public int getInitial_uid() {
		return initial_uid;
	}

	public void insert_uid(int uid) throws SQLException {
		userDAO.insertuid(uid);
	}

	public void insert_name(int uid, String name) throws SQLException {
		userDAO.insertname(uid, name);
	}

	public void insert_name_id(int uid, String name) throws SQLException {
		userDAO.insert_uid_name(uid, name);
	}

	public void insert_mail_id(int uid, String mailid) throws SQLException {
		userDAO.insert_mail_id(uid, mailid);
	}
	
}
