package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import windows.Main;
import windows.WelcomeWindow;
import javafx.event.ActionEvent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;


public class eventHandler 
{
	//Local UI interface variables linking
	@FXML
	private TextArea resultArea;
	@FXML
	private TextField userNameInput;
	@FXML
	private PasswordField passwordInput;
	@FXML
	private Hyperlink forgotPasswordLink;
	@FXML
	private Label invalidCombo;
	
	//Event methods
	@FXML
	private void submitData(ActionEvent actionEvent)
	{
		System.out.println("Submit button pressed");
	}
	
	@FXML
	private void forgotPassword(ActionEvent actionEvent)
	{
		setResultArea("Remember it next time...");
	}
	
	@FXML
	private void checkInput(ActionEvent actionEvent) throws InterruptedException
	{
		
		utilities.DatabaseConnection a = new utilities.DatabaseConnection();
		ResultSet resultsFromQuery= a.queryDatabase("SELECT * FROM USER");
		
		
		label:
		try
		{ 
			while (resultsFromQuery.next()) 
			{
		 
				if (getUsername().equals(resultsFromQuery.getString("username")))
				{
					
					if (getPassword().equals(resultsFromQuery.getString("password")))
					{
						setResultArea("Welcome back Louis\nLaunching welcome window...");
						System.out.println("Login details correct: launching new window");
		
						WelcomeWindow welcomeWindowInstance = new WelcomeWindow();
						break label;
						
					}
				}
			}
			
			invalidCombo();
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	
	@FXML
	private void invalidCombo()
	{
		System.out.println("User entered incorrect details displaying message...\n");
		invalidCombo.setOpacity(1);
	}

	
	//Getters and Setters
	private void setResultArea(String text) {
		resultArea.setText(text);
	}
	
	private String getResultArea() {
		return resultArea.getText();
	}

	private String getUsername() {
		return userNameInput.getText();
	}

	private String getPassword() {
		return passwordInput.getText();
	}

}
