package Mini_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class userlogin {

	public static ResultSet login() throws SQLException {
		Connection connection = null;
		Statement statement;
		ResultSet resultSet = null;

		String mysql = "jdbc:mysql://localhost:3306/simplebanking?autoReconnect=true&useSSL=false";
		String User = "root";
		String Pass = "42Sm@rtworld";

		try {
			connection = DriverManager.getConnection(mysql, User, Pass);
			statement = connection.createStatement();
			resultSet = statement.executeQuery("Select * from details ");
		} catch (Exception e) {
			System.out.println(e);
		}
		return resultSet;
	}

}
