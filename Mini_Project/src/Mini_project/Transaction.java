package Mini_project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Transaction {

	Scanner input = new Scanner(System.in);

	int loginUser() throws SQLException {
		System.out.println("\u001B[36mPlease Enter the UserName to Login:\u001B[37m");
		String userName = input.next();
		ResultSet resultSet = null;
		int accountNum = 0;
		ResultSet result = userlogin.login().getStatement()
				.executeQuery("select * from details where `username`= '" + userName + "'");
		if (result.next()) {
			// if (userName.equals(result.getString(2))) {
			System.out.println("\u001B[36mPlease Enter the Password:\u001B[37m");
			String password = input.next();
			resultSet = userlogin.login().getStatement().executeQuery(
					"select * from details where `password`='" + password + "' and `username`= '" + userName + "'");
			if (resultSet.next()) {
				System.out.println("\u001B[32mLogin Successful!\u001B[37m");
				System.out.println("\u001B[33mAccount number:\u001B[37m" + resultSet.getInt(1)
						+ " \u001B[33mName:\u001B[37m" + resultSet.getString(4));
				accountNum = resultSet.getInt(1);
			} else {
				System.out.println("\u001B[31mIncorrect Password. Try again!");
				System.exit(0);
			}
		} else {
			System.out.println("\u001B[31mIncorrect UserName. Try again! ");
			System.exit(0);
		}
		return accountNum;
	}

	void checkBalance(int accNo) throws SQLException {
		String sql = "Select * from details where account_no =" + accNo;
		ResultSet rs = userlogin.login().getStatement().executeQuery(sql);
		if (rs.next()) {
			System.out.print("\u001B[33mYour Account Balance: \u001B[37m");
			System.out.println(rs.getInt(5));
		}
	}

	void cashDeposit(int accNo) throws SQLException {
		System.out.println("\u001B[36mEnter the Amount to Deposit:\u001B[37m");
		int deposit = input.nextInt();
		String sql = "Select * from details where account_no =" + accNo;
		ResultSet rs = userlogin.login().getStatement().executeQuery(sql);
		if (rs.next()) {
			int balance = rs.getInt(5);
			deposit = deposit + balance;
		}
		// String sql = ("UPDATE details SET balance = `"+deposit +"`WHERE account_no
		// =`" + accNo+"`");
		userlogin.login().getStatement()
				.executeUpdate("update details set `balance` = " + deposit + " where (`account_no` =" + accNo + ")");
		System.out.println("\u001B[32mYour money has been deposited successfully!");
		System.out.println("\u001B[33mYour Updated Balance: \u001B[37m" + deposit);

	}

	void cashWithdraw(int accNo) throws SQLException {
		System.out.println("\u001B[36mEnter the Amount to Withdraw:\u001B[37m");
		int withdraw = input.nextInt();
		int balance = 0;
		int current = 0;
		String sql = "Select * from details where account_no =" + accNo;
		ResultSet rs = userlogin.login().getStatement().executeQuery(sql);
		if (rs.next()) {
			balance = rs.getInt(5);
			current = balance - withdraw;
		}
		if (withdraw <= balance) {
			userlogin.login().getStatement().executeUpdate(
					"update details set `balance` = " + current + " where (`account_no` =" + accNo + ")");
			System.out.println("\u001B[32mWithdrawal successful!");
			System.out.println("\u001B[33mYour Updated Balance: \u001B[37m" + current);
		} else {
			System.out.println("\u001B[31mYou dont have Sufficient balance!");

			checkBalance(accNo);
			System.out.print("Now ");
			cashWithdraw(accNo);
		}
	}
}
