/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.database;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Sachin
 */
public class DBService {
    

  static Connection con;
	public static Connection getconnection()
	{
 		try
		{
			Class.forName("com.mysql.jdbc.Driver");	
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/finalmapapp","root","root");
		        System.out.println("Connected");
                }
		catch(Exception e)
		{
			System.out.println("class error"+e);
		}
		return con;

}
        }

