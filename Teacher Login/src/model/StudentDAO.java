package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import utilities.SQLUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAO {
	
	//Query to Select a student
	
	public static Student searchStudent (String studentID) 
			throws SQLException, ClassNotFoundException {
		
		//Declaring a select statement
		String selectStmt = "SELECT * FROM student WHERE studentID = " + studentID;
		
		try {
			
			ResultSet rsStud = SQLUtil.dbExecuteQuery(selectStmt);
			
			Student student = getStudentFromResultSet(rsStud);
			
			//Returning the student object
			
			return student;
		} catch (SQLException e) {
			System.out.println("While searching a student with " + studentID + " id an error occurred" + e);
			
			throw e;
		}
	}
	
	private static Student getStudentFromResultSet(ResultSet rs) throws SQLException, ClassNotFoundException {
		
		Student stud = null;
		
		if(rs.next()) {
			
			stud = new Student();
			stud.setStudentID(rs.getInt("studentID"));
			stud.setFName(rs.getString("fName"));
			stud.setSName(rs.getString("sName"));
			stud.setAge(rs.getInt("age"));
			
		}
		
		return stud;
	}
	
	
	//Query to select studentS
	
	public static ObservableList<Student> searchStudents() throws SQLException, ClassNotFoundException {
		
		//Declaring the statement to execute.
		String selectStmt = "SELECT * FROM student";
		
		//Executing the declared statement
		
		try {
			
			ResultSet rsStuds = SQLUtil.dbExecuteQuery(selectStmt);
			ObservableList<Student> studList = getStudentList(rsStuds);
			
			return studList;
		} catch (SQLException e) {
			
			System.out.println("SQL select operation has failed: " + e);
			
			throw e;
		}
	}
	
	private static ObservableList<Student> getStudentList(ResultSet rs) throws SQLException, ClassNotFoundException {
		
		ObservableList<Student> studList = FXCollections.observableArrayList();
		
		while (rs.next()) {
			
			Student stud = new Student();
			stud.setStudentID(rs.getInt("studentID"));
			stud.setFName(rs.getString("fName"));
			stud.setSName(rs.getString("sName"));
			stud.setAge(rs.getInt("age"));
			
			studList.add(stud);
		}
		
		//return observable list of students
		
		return studList;
		
	}
	
	//Query to update a student's name
	
	public static void updateStudName (String studID, String studName) throws SQLException, ClassNotFoundException {
		
		String updateStmt = "update student set fName = '"+studName+"' where studentID = '"+studID+"'";
		
		//Executing the update statement
		
		try {
			SQLUtil.dbExecuteUpdate(updateStmt);
			System.out.printf("Update Statement: %s\n", updateStmt);
		} catch (SQLException e) {
			System.out.println("Error occurred while UPDATE operation: " + e);
			throw e;
		}
		
	}
	
	
	//Query to delete a student
	
	public static void deleteStudentWithID (String studID) throws SQLException, ClassNotFoundException {
		
		//Declaring a delete statement
		String deleteStmt = "delete from student where studentID = '"+studID+"'";
		
		//Executing the delete statement
		
		try {
			SQLUtil.dbExecuteUpdate(deleteStmt);
			System.out.printf("Delete Statement: %s\n", deleteStmt);
		} catch (SQLException e) {
			System.out.println("Error occurred while DELETE operation: " + e);
			throw e;
		}
	}
	
	
	//Query to insert an student
	
	public static void insertStudent (String fname, String sname, String age) throws SQLException, ClassNotFoundException {
		
		//Declaring an insert statement
		
		String insertStmt = "insert into student values (NULL, '"+fname+"', '"+sname+"', '"+age+"')";
		
		//Executing the insert statement
		
		try {
			SQLUtil.dbExecuteUpdate(insertStmt);
			System.out.printf("Insert Statement: %s\n", insertStmt);
		} catch (SQLException e) {
			System.out.println("Error occurred while INSERT Operation: " + e);
			throw e;
		}
	}
}

