package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class createuser {
	//DELETE FROM `simplebanking`.`details` WHERE (`account_no` = '104586');
	//public static void main(String args[]) {
		 static void newuser() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/simplebanking?autoReconnect=true&useSSL=false", "root","42Sm@rtworld");
			Statement stmt = connection.createStatement();
			stmt.executeUpdate("INSERT INTO `simplebanking`.`details` (`username`, `password`, `name`, `balance`) VALUES ('vishnu05priya', 'hell0w0rld', 'Vishnu Priya C', '5000');\r\n"+ "");
			System.out.println("Your Account_no	  Name and   initial deposit of 5000");
			ResultSet rs = stmt.executeQuery("select * from details where username='vishnu05priya'");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "		" + rs.getString(4) + "		" + rs.getString(5));
				System.out.println("\u001B[32mAccount created successfully /n");
			}
		} catch (Exception e) {
			System.out.println("\u001B[31mUsername taken. Kindly refresh your page and try a different username.");
			System.exit(0);
		}
	 }
}