package com.oosd.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.oosd.App;
import com.oosd.util.Constants;
import com.oosd.util.CommonUtility;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
*
* @author  Nidhi Chawla
* @version 1.0
* @classDescription This class start the initial game with the splash screen
* 
*/

public class SplashController implements Initializable {

	@FXML
	BorderPane borderPane;

	/**
	 * initialize Splash Controller after the root element 
	 * is processed  
	 */
	
	public void initialize(URL location, ResourceBundle resources) {
		new SplashScreen().start();

	}
	
	/**
	 * Splash screen Window Display is controlled 
	 * by the thread function
	 */

	class SplashScreen extends Thread {

		public void run() {
			try {
				Thread.sleep(5000);

				Platform.runLater(new Runnable() {

					public void run() {
						App.splashStage.close();
						try {
						FXMLLoader fxmlLoader = new FXMLLoader(CommonUtility.class.getResource("/view/" + "Board" + ".fxml"));
						Parent root = (Parent) fxmlLoader.load();
						App.window = new Stage();
						App.window.setTitle(Constants.APPLICATION_TITLE);
						App.window.setScene(new Scene(root));	
						App.window.initStyle(StageStyle.UNDECORATED);
						App.window.setFullScreen(true);
						App.window.showAndWait();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				});

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
