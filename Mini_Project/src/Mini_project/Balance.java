package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Balance {
	
	Connection con = null;
	Statement statement;
	ResultSet resultSet;
	ResultSet resultSet1;
	String mysql = "jdbc:mysql://localhost:3306/simplebanking?autoReconnect=true&useSSL=false";
	String User = "root";
	String Pass = "42Sm@rtworld";
	
	public static void checkUserBalance() {
	Scanner input=new Scanner(System.in);
	System.out.println("\u001B[33m \t\t_____VIEW BALANCE_____");
	System.out.println("\u001B[36mEnter your account number to view your account balance:\u001B[37m \n");
	int id=input.nextInt();
	Balance balance = new Balance();
	
	balance.Checkbalance(id);
	}
	 public void Checkbalance(int id) {
		 
		try {
			int balance = 0;
			con = DriverManager.getConnection(mysql, User, Pass);
			statement = con.createStatement();
			resultSet1 = statement.executeQuery("Select * from details where account_no= " + id);
			
			while (resultSet1.next()) {
				balance = +resultSet1.getInt(5);
				String name=resultSet1.getString(4);
				name=name.toUpperCase();
				System.out.println(name+" Your Acoount Balance is "+balance);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}