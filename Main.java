package management;

import java.sql.SQLException;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		System.out.println(
				"                                                      WELCOME TO GENDRAL QUIZ TEST             "
						+ "\n");
		// Scanner -> user input

		User u1 = new User();
		int uid = u1.getInitial_uid() - u1.count();

		System.out.println("YOUR USER_ID " + uid);

		// inserting uid to db
		// u1.insert_uid(uid);

		Scanner sc = new Scanner(System.in);
		System.out.print("YOUR NAME : ");
		String name = new String();
		name = sc.nextLine();
		name = name.replaceAll(" ", "_");

		System.out.print("YOUR MAIL_ID : ");
		Scanner sc2 = new Scanner(System.in);
		String mail_id = sc2.nextLine();

		System.out.println("WELCOME " + name.toUpperCase());
		// inserting name to db
		// u1.insert_name(uid,name);

		System.out.println("Input your full name: Ensure it includes both your first name and last name.\r\n"
				+ "Spaces are replaced: Any spaces will automatically be converted to underscores.\n"
				+ "Limited chances: You are allowed only 2 attempts in case of mistakes. Enter carefully!\n"
				+ "Important: Note your UID carefully (or)  give your mail properly for future reference. It will be required for subsequent requests.\n");

		System.out.println("Willing to Start Press '1' or '0' to left \n");
		int useropt = sc.nextInt();

		Quiz q1 = new Quiz();
		int revolve = 1;

		while (revolve <= 10) {
			if (useropt != 1) {
				revolve = 11;
				System.out.println("OK BYE NEWBIE ");
				break;
			}

			System.out.print(revolve + ") ");
			q1.DisplayQuestions(revolve);
			q1.DisplayChoices(revolve);

			System.out.print("ANS : ");
			char ans = sc.next().charAt(0);

			int chance = 2;
			while (chance >= 0 && ans != 'a' && ans != 'b' && ans != 'c' && ans != 'd' && ans != 'A' && ans != 'B'
					&& ans != 'c' && ans != 'D') {
				if (chance == 0) {
					System.out.println("limit exceed 'move on next' ");
					chance = 0;
					break;
				}
				System.out.println("invalid!! ( Chance left " + chance + " )");
				chance--;
				System.out.print("Enter : ");
				ans = sc.next().charAt(0);
			}

			q1.add_user_option(ans, revolve);

			if (revolve == 10) {

				System.out.println("  Finished ");

				int yourscore = q1.evaluate_ans();

				// db insertion
				u1.insert_name_id(uid, name);
				u1.addans(yourscore, uid);
				u1.insert_mail_id(uid, mail_id);

				if (yourscore > 7) {
					System.out.println("Excellent " + "Your_Score: " + yourscore);
				} else if (yourscore <= 7 && yourscore >= 5) {
					System.out.println("GOOD" + " Your_Score: " + yourscore);
				} else {
					System.out.println("Nice Try!  " + "\n" + yourscore);
				}
			}

			revolve++;
		}
	}

}
