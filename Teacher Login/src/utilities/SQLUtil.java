package utilities;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;


public class SQLUtil {
	
	//Database Driver 
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

	//Connection Declaration 
	private static Connection conn = null;
	
	//Connection strings
	private static final String dbString = "jdbc:mysql://localhost:3306/teacherLogin?verifyServerCertificate=false&useSSL=true";
	private static final String dbUserName = "root";
	private static final String dbPassword = "password";
	
	public static void dbConnect() throws SQLException, ClassNotFoundException {
		
		//Setting up the driver
		
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver Present?");
			e.printStackTrace();
			throw e;
		}
		
		System.out.println("Driver Found. Establishing Connection.");
		
		//Connecting using the connection string
		
		try {
			
			conn = DriverManager.getConnection(dbString, dbUserName, dbPassword);
		} catch (SQLException e) {
			
			System.out.println("Connection has failed." + e);
			throw e;
		}
	}
	
	//Closing Connection
	public static void dbDisconnect() throws SQLException {
		try {
			
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	//Executing Database Query Operations
	public static ResultSet dbExecuteQuery(String queryStatement) throws SQLException, ClassNotFoundException {
		
		Statement statement = null;
		ResultSet resultSet = null;
		CachedRowSetImpl crs = null;
		try {
			
			dbConnect();
			System.out.println("Select Statement: " + queryStatement + "\n");
			
			statement = conn.createStatement();
			
			resultSet = statement.executeQuery(queryStatement);
			
			
			//CachedRowSet 
			//Prevents closed connection error
			crs = new CachedRowSetImpl();
			crs.populate(resultSet);
			
		} catch (SQLException e) {
			
			System.out.println("Problem with SQL operation : " + e);
			throw e;
			
		} finally {
			if (resultSet != null) {
				
				resultSet.close();
			}
			if (statement != null) {
				
				statement.close();
			}
			
			dbDisconnect();
		}
		return crs;
	}
	
	public static void dbExecuteUpdate (String sqlStmt) throws SQLException, ClassNotFoundException {
		
		//Initialising statement to null
		Statement stmt = null;
		
		//SQL Query - contained in try block.
		try {
			//Connecting to the database
			dbConnect();
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlStmt);
				
		} catch (SQLException e) {
			
			System.out.println("Problem occured at operation : " + e);
			throw e;
		} finally {
			if (stmt != null) {
				
				stmt.close();
			}
			
			dbDisconnect();
		}
	}
}
