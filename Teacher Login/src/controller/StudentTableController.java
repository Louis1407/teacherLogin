package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import model.Student;
import model.StudentDAO;
import javafx.scene.control.TextField;


import java.sql.SQLException;

public class StudentTableController {
	
	@FXML
	private TextField studIdText;
	
	@FXML
	private TextArea resultArea;
	
	@FXML
	private TextField newNameText;
	
	@FXML
	private TextField fnameText;
	
	@FXML
	private TextField snameText;
	
	@FXML
	private TextField ageText;
	
	@FXML
	private TableView<Student> studentTable;
	
	@FXML
	private TableColumn<Student, Integer> studIdColumn;
	
	@FXML
	private TableColumn<Student, String> studFNameColumn;
	
	@FXML
	private TableColumn<Student, String> studSNameColumn;
	
	@FXML
	private TableColumn<Student, Integer> studAgeColumn;	

	
	@FXML
	private void searchStudent (ActionEvent actionEvent) throws ClassNotFoundException, SQLException {
		
		try {
			
			Student stud = StudentDAO.searchStudent(studIdText.getText());
			populateAndShowStudent(stud);
		} catch (SQLException e) {
			e.printStackTrace();
			resultArea.setText("Error occurred while getting student information");
			throw e;
		}
	}
	
	@FXML
	private void searchStudents(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		
		try {
			
			ObservableList<Student> studData = StudentDAO.searchStudents();
			populateStudents(studData);
		} catch (SQLException e) {
			
			System.out.println("Error occurred while getting student information");
			throw e;
		}
	}
	
	@FXML
	private void initialize () {
		
		studIdColumn.setCellValueFactory(cellData -> cellData.getValue().studentIDProperty().asObject());
		studFNameColumn.setCellValueFactory(cellData -> cellData.getValue().fNameProperty());
		studSNameColumn.setCellValueFactory(cellData -> cellData.getValue().sNameProperty());
		studAgeColumn.setCellValueFactory(cellData -> cellData.getValue().ageProperty().asObject());
	}
	
	@FXML
	private void populateStudent (Student stud) throws ClassNotFoundException {
		
		ObservableList<Student> studData = FXCollections.observableArrayList();
		studData.add(stud);
		studentTable.setItems(studData);
	}
	
	@FXML
	private void populateAndShowStudent(Student stud) throws ClassNotFoundException {
		
		if ( stud != null ) {
			populateStudent(stud);
			setStudInfoToTextArea(stud);
		} else {
			resultArea.setText("This student does not exist");
			
		}
	}
	
	@FXML
	private void setStudInfoToTextArea (Student stud) {
		
		resultArea.setText("First Name: " + stud.getStudentFName() + " " + stud.getStudentSName() + "\n");
	}
	
	@FXML
	private void populateStudents (ObservableList<Student> studData) throws ClassNotFoundException {
		
		studentTable.setItems(studData);
	}
	
	@FXML
	private void updateStudentName (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		
		try {
			StudentDAO.updateStudName(studIdText.getText(), newNameText.getText());
			resultArea.setText("Name has been updated for student id: " + studIdText.getText() + "\n");
		
		} catch (SQLException e) {
			resultArea.setText("Problem occurred while updating name: " + e);
		}
	}
	
	@FXML
	private void insertStudent (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			StudentDAO.insertStudent(fnameText.getText(), snameText.getText(), ageText.getText());
			resultArea.setText("student inserted!");
		} catch (SQLException e) {
			resultArea.setText("Problems occured while inserting student " + e);
			throw e;
		}
	}
	
	@FXML
	private void deleteStudentWithID (ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
		try {
			StudentDAO.deleteStudentWithID(studIdText.getText());
			resultArea.setText("Student deleted! Student id: " + studIdText.getText() + "\n");
		} catch (SQLException e) {
			resultArea.setText("Problem occured while deleting employy " + e);
			throw e;
		}
	}
}

