package com.oosd.util;

import java.io.IOException;

import com.oosd.App;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
* 
* @author  Nidhi Chawla
* @version 1.0
* @classDescription  CommonUtility is a class that loads the UI.   				  
* 
*/
public class CommonUtility {

	public static Stage newStage; 

	/**
	 * 
	 * @param sceneName  set the scene name
	 * @throws IOException
	 *              This method set the scene to the stage 
	 */
	public static void openNewScene(String sceneName) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(CommonUtility.class.getResource("/view/" + sceneName + ".fxml"));
		Parent root = (Parent) fxmlLoader.load();
		App.window.setScene(new Scene(root));
		App.window.show();
	}

	/**
	 * 
	 * @param sceneName  set the scene name
	 * @param title      set the title name
	 * @throws IOException
	 */
	public static void openNewWindow(String sceneName, String title) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(CommonUtility.class.getResource("/view/" + sceneName + ".fxml"));
		Parent root = (Parent) fxmlLoader.load();
		newStage = new Stage();
		newStage.setTitle(title);
		newStage.initModality(Modality.APPLICATION_MODAL);
		newStage.setScene(new Scene(root));
		newStage.initStyle(StageStyle.UNDECORATED);
		newStage.showAndWait();
	}

	/**
	 * 
	 * @param sceneName  set the scene name
	 * @param title      set the title name
	 * @throws IOException
	 *             This method display the error window
	 */

	public static void openErrorWindow(String sceneName, String title) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(CommonUtility.class.getResource("/view/" + sceneName + ".fxml"));
		Parent root = (Parent) fxmlLoader.load();
		newStage = new Stage();
		newStage.setTitle(title);
		newStage.setScene(new Scene(root));
		newStage.showAndWait();
		
	}
	
}
