package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class RootLayoutController {
	
	//Exiting the program;
	public void handleExit(ActionEvent actionEvent) {
		System.exit(0);
	}
	
	public void handleHelp(ActionEvent actionEvent) {
		
		Alert alert = new Alert (Alert.AlertType.INFORMATION);
		alert.setTitle("Program Information");
		alert.setHeaderText("Program created by Elliot C + Louis F");
		alert.setContentText("You can search, delete, update name and insert new students!");
		alert.show();
	}

}
