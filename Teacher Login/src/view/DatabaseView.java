package view;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class DatabaseView extends Application

{
	private BorderPane rootLayout;
	
	//setScene
	public DatabaseView()
	{
		Main.setStageTitle("Database View");
		initStudentRootLayout();
		showStudentTableView();
	}	
	
	public void initStudentRootLayout() {
		
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("StudentRootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			Main.setScene(scene);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showStudentTableView() {
		try {
			
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("StudentScene.fxml"));
			AnchorPane studentOperationsView = (AnchorPane) loader.load();
			
			rootLayout.setCenter(studentOperationsView);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {System.out.println("HELLO");}
}
