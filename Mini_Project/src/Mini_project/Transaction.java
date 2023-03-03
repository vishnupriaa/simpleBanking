package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Transaction {

	Connection con = null;
	Statement statement;
	
	ResultSet resultSet1;
	String mysql = "jdbc:mysql://localhost:3306/simplebanking?autoReconnect=true&useSSL=false";
	String User = "root";
	String Pass = "42Sm@rtworld";
	
	public static void cashDeposit() {
	Scanner input=new Scanner(System.in);
	System.out.println("\u001B[33m \t\t_____DEPOSIT_____");
	System.out.println("\u001B[36mEnter your account number:\u001B[37m");
	int id=input.nextInt();
	Transaction jc = new Transaction();
	
	System.out.println("\u001B[36mEnter the amount to make a deposit:\u001B[37m");
	int deposit=input.nextInt();
	
	jc.updateConnection(id,deposit);
	
	}
	
	public static void cashWithdraw() {
		Scanner input=new Scanner(System.in);
		System.out.println("\u001B[33m \t\t_____WITHDRAW_____");
		System.out.println("\u001B[36mEnter your account number:\u001B[37m");
		int id=input.nextInt();
		Transaction jc = new Transaction();
		
		System.out.println("\u001B[36mEnter the amount to withdraw:\u001B[37m");
		int withdraw=input.nextInt();
		
		jc.withdrawCash(id,withdraw);
		
		}

	public void updateConnection(int id, int deposit) {
		try {

			int balance =deposit;
			con = DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet1 = statement.executeQuery("Select * from details where account_no= " + id);
			while (resultSet1.next()) {
				int totalbalance = +resultSet1.getInt(5);
				balance+=totalbalance;
				statement.executeUpdate("UPDATE details SET balance = '" + balance + "' WHERE account_no = '" + id + "'");
				System.out.println("\u001B[32mCash Deposited Successfully!\u001B[37m");
				System.out.println("Your current balance is:"+balance+"\n");
			}
		} catch (Exception e) {
			//System.out.println(e);
		}
	}
	
	public void withdrawCash(int id, int deposit) {
		try {

			int balance =deposit;
			con = DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet1 = statement.executeQuery("Select * from details where account_no= " + id);
			while (resultSet1.next()) {
				int totalbalance = resultSet1.getInt(5);
				if(totalbalance>=deposit) {
				balance=(totalbalance)-balance;
				statement.executeUpdate("UPDATE details SET balance = '" + balance + "' WHERE account_no = '" + id + "'");
				System.out.println("\u001B[32mTransaction Successful. Withdraw your cash.\u001B[37m");
				System.out.println("Your current balance is:"+balance+"\n");
			}
			else {
				System.out.println("\u001B[31mInsuffieient Balance.");
			}}
		} catch (Exception e) {
			//System.out.println(e);
		}
	}
	

}
