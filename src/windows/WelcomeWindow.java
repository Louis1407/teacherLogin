package windows;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class WelcomeWindow extends Application
{
	private BorderPane rootLayout;
	
	//setScene
	public WelcomeWindow()
	{
		Main.setStageTitle("Welcome Screen");
		initBorderLayout();
	}	
	
	public void initBorderLayout()
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("welcomeUserLayout.fxml"));
			rootLayout = (BorderPane) loader.load();

			Scene scene2 = new Scene(rootLayout);
			
			Main.setScene(scene2);	
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {System.out.println("HELLO");}
}

