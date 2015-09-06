package test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * This program tests that the database and the JDBC driver are correctly
 * configured.
 * 
 * @version 1.02 2012-06-05
 * @author Cay Horstmann
 */
public class TestDB {
	public static void main(String args[]) throws IOException {
		try {
			runTest();
		} catch (SQLException ex) {
			for (Throwable t : ex)
				t.printStackTrace();
		}
	}

	/**
	 * Runs a test by creating a table, adding a value, showing the table
	 * contents, and removing the table.
	 */
	public static void runTest() throws SQLException, IOException {

		try (Connection conn = getConnection()) {
			Statement stat = conn.createStatement();

			// stat.executeUpdate("CREATE TABLE Greetings (Message CHAR(20),
			// Count INT)");
			String sqlCommand;
			int max;
			sqlCommand = "SELECT MAX(Count) From Greetings";
			ResultSet resultMax = stat.executeQuery(sqlCommand);
			if (resultMax.next())
				max = resultMax.getInt(1);
			else
				max = 1;
			resultMax.close();

			for (int i = max + 1; i <= (max + 10000); i++) {
				sqlCommand = "INSERT INTO Greetings VALUES ('Hello, World " + i + "!', " + i + ")";
				System.out.println(sqlCommand);
				stat.executeUpdate(sqlCommand);
			}

			try (ResultSet result = stat.executeQuery("SELECT * FROM Greetings")) {
				while (result.next())
					System.out.println(result.getString(1).trim() + " - " + result.getInt(2));
				result.close();
			}
			// stat.executeUpdate("DROP TABLE Greetings");
		}
	}

	/**
	 * Gets a connection from the properties specified in the file
	 * database.properties.
	 * 
	 * @return the database connection
	 */
	public static Connection getConnection() throws SQLException, IOException {
		Properties props = new Properties();
		try (InputStream in = Files
				.newInputStream(Paths.get("d:/JavaDev/workspace/Horstman/src/test/database.properties"))) {

			props.load(in);

		}

		String drivers = props.getProperty("jdbc.drivers");
		if (drivers != null)
			System.setProperty("jdbc.drivers", drivers);
		String url = props.getProperty("jdbc.url");
		String username = props.getProperty("jdbc.username");
		String password = props.getProperty("jdbc.password");

		return DriverManager.getConnection(url, username, password);
	}
}
