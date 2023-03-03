package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
public class userlogin {
	static void login() {
		Connection connection=null;
		try 
		{
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/simplebanking?autoReconnect=true&useSSL=false","root","42Sm@rtworld");
			Statement ss=(Statement) connection.createStatement();
			Scanner input =new Scanner(System.in);
			System.out.println("\u001B[33m \t\t_____WELCOME TO THE LOGIN PAGE_____");
			System.out.print("\u001B[36mEnter the Username: \u001B[37m");
			String userName =input.next();
			System.out.print("\u001B[36mEnter the Password: \u001B[37m");
			String password=input.next();
			ResultSet rs=ss.executeQuery("select * from details where username ='"+userName+"'");
			while(rs.next()) {
				if(password.equals(rs.getString(3)))
				{	
				System.out.println("\n\u001B[32mLogin successful!");
				}
				else {
					System.out.println("\u001B[31mIncorrect password.Refresh your page and try again.");
					System.exit(0);
				}
				}
		}catch(Exception e) {
		}
	}
}
