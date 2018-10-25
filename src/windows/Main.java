package windows;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class Main extends Application 
{
	private static Stage primaryStage;
	public static String args;
	private BorderPane rootLayout;
	
	@Override
	public void start(Stage primaryStage) 
	{
		try 
		{
			Main.primaryStage = primaryStage;
			Main.primaryStage.setTitle("Login Screen");
			initBorderLayout();
		} 
		
		catch(Exception e) 
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
	
	public void initBorderLayout()
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("MenuLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			initAnchorLayout();
			
			Scene scene = new Scene(rootLayout);
			
			setScene(scene);		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void setStageTitle(String string)
	{
		primaryStage.setTitle(string);
	}
	
	public void initAnchorLayout()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("DisplayGroup.fxml"));
			AnchorPane itemLayout = (AnchorPane) loader.load();
			
			rootLayout.setCenter(itemLayout);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
