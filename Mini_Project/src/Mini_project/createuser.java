package Mini_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class createuser {
	// DELETE FROM `simplebanking`.`details` WHERE (`account_no` = '104586');
	// public static void main(String args[]) {
	Scanner input = new Scanner(System.in);

	void newuser() throws SQLException {
		System.out.println("\u001B[36mPlease Enter the Name:\u001B[37m");
		String name = input.next();
		System.out.println("\u001B[36mPlease Enter the UserName:\u001B[37m");
		String userName = input.next();
		System.out.println("\u001B[36mPlease Enter the Password:\u001B[37m");
		String password = input.next();
		System.out.println("Please Enter the Amount to Deposit");
		int acc = input.nextInt();
		while (acc < 5000) {
			System.out.println("Please Enter the Amount above 5000 Deposit");
			acc = input.nextInt();
		}
		ResultSet result = userlogin.login();
		boolean create = true;
		while (result.next()) {
			// System.out.println(result.getString(2) + result.getString(3));
			if (userName.equals(result.getString(2))) {
				create = false;
				System.out.println("\u001B[31mPlease again re-enter the details username already taken\n");
				newuser();
			}
		}
		if (create) {
			userlogin.login().getStatement().execute(
					"INSERT INTO `simplebanking`.`details` (`username`, `password`, `name`, `balance`) VALUES ('"
							+ userName + "', '" + password + "', '" + name + "', '" + acc + "')");

			System.out.println("\u001B[32mAccount Created Successfully");
			result.close();
		}
	}
}