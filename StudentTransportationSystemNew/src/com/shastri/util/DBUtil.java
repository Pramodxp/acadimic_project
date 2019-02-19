package com.shastri.util;

/**
 *Cluster Info Solution Pvt Ltd Sharanabasu
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			 con = DriverManager.getConnection("jdbc:mysql://localhost/finalmapapp","root", "root");
			//con = DriverManager
					//.getConnection(
							//"jdbc:mysql://http://node38557-mapappa.cloud.cms500.com/finalmapapp",
							//"root", "YRFrsa18491");

		} catch (ClassNotFoundException e) {
			System.err.println("Connection Class Loading Failed");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err
					.println("Error occured while getting database connection");
			e.printStackTrace();
		}
		return con;
	}

}
