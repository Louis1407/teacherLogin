package view;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import view.Main;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static Stage primaryStage;
	private BorderPane rootLayout;
	public static String args;
	
	
	@Override
	public void start(Stage primaryStage) {
		System.out.println("Hello");
		Main.primaryStage = primaryStage;
		
		Main.primaryStage.setTitle("Teacher Login");
		
		initWelcomeBorderLayout();
		System.out.println("Hello");
	}
	
	public void initWelcomeBorderLayout()
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("LoginMenuLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			initWelcomeAnchorLayout();
			
			Scene scene = new Scene(rootLayout);
			
			setScene(scene);
			System.out.println("Hello");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void initWelcomeAnchorLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("LoginLayout.fxml"));
			AnchorPane itemLayout = (AnchorPane) loader.load();
			
			rootLayout.setCenter(itemLayout);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void setScene(Scene scene)
	{
		primaryStage.setScene(scene);
		
		primaryStage.show();
	}
	
	public static void closeStage()
	{
		primaryStage.close();
	}
	
	public static void setStageTitle(String string)
	{
		primaryStage.setTitle(string);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

