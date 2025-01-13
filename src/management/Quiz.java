package management;

import java.sql.SQLException;

public class Quiz {
	private String arr[];
	private char ans[];
	public static int users;

	Quiz() {
		arr = new String[10];
		ans = new char[10];
		users += 1;
	}

	public void DisplayQuestions(int idc) throws SQLException {
		arr = QuizDAO.displayQuestions_og();
		System.out.println(arr[idc - 1]);
	}

	public void DisplayChoices(int idc) throws SQLException {
		QuizDAO.getchoices(idc);
	}

	public void add_user_option(char c, int revolve) {
		
		ans[revolve - 1] = c;

	}

	public int evaluate_ans() throws SQLException {
		return QuizDAO.checkScore(ans);
	}

	public void display_MY_ans() throws SQLException {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + ") " + ans[i]);
		}
	}
}
