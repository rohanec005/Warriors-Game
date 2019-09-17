package com.oosd;

import com.oosd.model.Board;
import com.oosd.util.Constants;
import com.oosd.util.Creator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
* 
* 
* @author  Nidhi Chawla
* @version 1.0
* @superclass Application
* @classDescription Main class 
* 					The App Class program Launches the Warrior Combat game  
* 					with Splash screen
* 
*/

public class App extends Application
{

	public static Stage window; // Declaration of Window Stage
	public static Stage splashStage; // Declaration of Splash Stage
	public static boolean isSplashLoaded = false; // Set the initial splash Screen Stage to False
	
    public static void main( String[] args )
    {
     //Launch JavaFX Application
     	launch(args);
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		splashStage = primaryStage;
		//Set up initial scene.
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(Constants.SPLASH_SCREEN));
		Scene scene = new Scene(root);// Create the Scene
		primaryStage.initStyle(StageStyle.UNDECORATED);// Set the style of stage
		primaryStage.setTitle(Constants.APPLICATION_TITLE);//Set the Game Title to the Stage.
		
		primaryStage.setScene(scene);// Set the Main Scene to the stage.
		primaryStage.show();// Display the stage
		
	}
}
