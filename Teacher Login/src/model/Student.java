package model;

import javafx.beans.property.*;

public class Student {
	
	//Declaring the Student Data Columns
	//Found in the database
	
	
	private IntegerProperty studentID;
	private StringProperty fName;
	private StringProperty sName;
	private IntegerProperty age;
	
	public Student() {
		
		this.studentID = new SimpleIntegerProperty();
		this.fName = new SimpleStringProperty();
		this.sName = new SimpleStringProperty();
		this.age = new SimpleIntegerProperty();
		
	}
	
	//Student ID Getters and Setters
	
	public int getStudentID() {
		
		return studentID.get();
	}
	
	public void setStudentID(int studentID) {
		
		this.studentID.set(studentID);
	}
	
	public IntegerProperty studentIDProperty() {
		
		return studentID;
	}
	
	//Student name getters and setters
	
	public String getStudentFName() {
		
		return fName.get();
	}
	
	public void setFName(String name) {
		
		this.fName.set(name);
	}
	
	public StringProperty fNameProperty() {
		
		return fName;
	}
	
	public String getStudentSName() {
		
		return sName.get();
	}
	
	public void setSName(String name) {
		
		this.sName.set(name);
	}
	
	public StringProperty sNameProperty() {
		
		return sName;
	}
	
	//Student age getters and setters
	
	public int getAge() {
		
		return age.get();
	}
	
	public void setAge(int age) {
		
		this.age.set(age);
	}
	
	public IntegerProperty ageProperty() {
		
		return age;
	}
}
