package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sun.rowset.CachedRowSetImpl;

public class DatabaseConnection 
{
	private static Connection con = null;
	private static final String dbString = "jdbc:mysql://localhost:3306/people?verifyServerCertificate=false&useSSL=true";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	
	
	public static void dbConnect()
	{
		try 
		{
			Class.forName(driver);
			System.out.println("Found driver\n");
			
			con = DriverManager.getConnection(dbString, dbUserName, dbPassword);
			System.out.println("Connection established\n\n");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void dbClose()
	{
		try 
		{
			con.close();
			System.out.println("Database connection closed.\n");
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public ResultSet queryDatabase(String userQuery)
	{
		CachedRowSetImpl crs = null;
		try
		{
			dbConnect();

			Statement stat = con.createStatement();
			System.out.printf("Executing %s\n", userQuery);
			ResultSet res = stat.executeQuery(userQuery);
			System.out.printf("Successfully executed %s\n\n", userQuery);
			
			crs = new CachedRowSetImpl();
			crs.populate(res);

			res.close();
			stat.close();
			
			dbClose();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return crs;
			
	}
	
}
