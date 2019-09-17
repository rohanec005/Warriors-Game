package com.oosd.view;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.oosd.controller.BoardController;
import com.oosd.model.Location;
import com.oosd.model.Piece;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
* 
*  
* @author  Nidhi Chawla
* @version 2.0
* @classDescription Displays the Warrior Combat game page of the UI by  
*                   Implementing initializable interface by automatically .
* 					inserting location and resources properties into the controller. 
* 
*/


public class BoardView implements Initializable {

	/**
	 * 
	 * These are the FXML variables that are set in Board.fxml and
	 * linked to Game controller. These FXML variables regulates with 
	 * written methods and runs the game. 
	 * 
	 */
	
	@FXML
	GridPane gridPane;

	@FXML
	private ImageView pieceMagneto1;

	@FXML
	private ImageView pieceMagneto2;

	@FXML
	private ImageView pieceJean2;

	@FXML
	private ImageView pieceCharlesXavier;

	@FXML
	private ImageView pieceWolverine2;

	@FXML
	private ImageView pieceWolverine3;

	@FXML
	private ImageView pieceJean3;

	@FXML
	private ImageView pieceMagneto3;

	@FXML
	private ImageView pieceJean1;

	@FXML
	private ImageView pieceWolverine1;

	@FXML
	private ImageView pieceHulk1;

	@FXML
	private ImageView pieceThor1;

	@FXML
	private ImageView pieceBlackWidow2;

	@FXML
	private ImageView pieceThor2;

	@FXML
	private ImageView pieceIronMan;

	@FXML
	private ImageView pieceThor3;

	@FXML
	private ImageView pieceBlackWidow3;

	@FXML
	private ImageView pieceHulk3;

	@FXML
	private ImageView pieceBlackWidow1;

	@FXML
	private ImageView pieceHulk2;

	@FXML
	private Text currentPlayerText;

	@FXML
	private Text messageText;

	@FXML
	private ImageView myImageView2;

	@FXML
	private ImageView myImageView;
	
	boolean successfulMove; 
	
	private boolean attackButtonClicked = false;
	private boolean defenceButtonClicked = false;
	ImageView source,target;
	Dragboard db;
	BoardController boardController;
	
	/**
	 * 
	 * @param location
	 * @param resources
	 * 			initialize method instantiate(Creates) the board game and sets the 
	 *  		location of pieces on the board.
	 *  
	 */
	
	public void initialize(URL location, ResourceBundle resources) {
		boardController= BoardController.getInstance();
		boardController.createBoard();
		setInitialLocationOfPieces();
	}

	/**
	 * 
	 * @param board
	 * 			setInitialLocationofpieces method set the pieces in the Gridpane node 
	 *  		with their respective id and image of piece using coordinates.
	 *  
	 */
	private void setInitialLocationOfPieces() {
		try{
			List<Piece> pieces = boardController.getPieces();
			for(Piece piece:pieces){
				System.out.println(piece.getName());
				AnchorPane anchorPane = (AnchorPane) getNodeFromGridPane(piece.getLocation().getyCoordinate(),piece.getLocation().getxCoordinate());
				ImageView imgView = (ImageView)anchorPane.getChildren().get(0);
				imgView.setImage(new Image(piece.getImagePath()));
				imgView.setId(piece.getId());
				imgView.setPreserveRatio(true);		
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*private void setpieceForAGivenLocation(Piece piece, Location loc){
		AnchorPane anchorPane = (AnchorPane) getNodeFromGridPane(loc.getyCoordinate(),loc.getxCoordinate());
		ImageView imgView = (ImageView)anchorPane.getChildren().get(0);
		imgView.setImage(new Image(piece.getImagePath()));
		imgView.setId(piece.getId());
		imgView.setPreserveRatio(true);
	}*/
	
	/**
	 * 
	 * @param de
	 * 			imageDragOver(DragEvent) is an event that copies and moves 
	 * 			the image as user chooses.  
	 *  		
	 */
	@FXML
	void imageDragOver(DragEvent de) {
		if (de.getDragboard().hasImage()) {
			/* allow for both copying and moving, whatever user chooses */
			de.acceptTransferModes(TransferMode.ANY);
		}
		de.consume();
	}
	
	/**
	 * 
	 * @param event
	 * 			onDragDetected(MouseEvent) is an event that runs when the 
	 *  		drag gesture of image is selected.
	 *  
	 */
	
	@FXML
	void onDragDetected(MouseEvent event) {
		messageText.setText("");
		ClipboardContent content = new ClipboardContent();
		source = (ImageView)event.getPickResult().getIntersectedNode() ;
		db = source.startDragAndDrop(TransferMode.ANY);
		content.putImage(source.getImage());
		db.setContent(content);
		event.consume();
	}
	
	/**
	 * 
	 * @param event
	 * 			onDragDropped(DragEvent) is an event that moves the image 
	 *          and  sets the location and id of the current player when  
	 *          the node is released during Drag and drop gesture.
	 */	
	@FXML
	void onDragDropped(DragEvent event) {
		db = event.getDragboard();
		if (db.hasImage()) {
			target = (ImageView)event.getPickResult().getIntersectedNode();
			Integer colIndex = GridPane.getColumnIndex(target.getParent());
			Integer rowIndex = GridPane.getRowIndex(target.getParent());
			Location destination = new Location(rowIndex, colIndex);
			successfulMove = boardController.move(attackButtonClicked, defenceButtonClicked, source.getId(), destination);
		}

		/* let the source know whether the string was successfully 
		 * transferred and used */
		event.setDropCompleted(successfulMove);

		event.consume();
	}

	/**
	 * 
	 * @param event
	 * 			onDragDone(DragEvent) is an event happens when the user 
	 *          select the Node and performs the Drag and drop gesture by 
	 *          dragging it from source to the dropping to the destination.
	 *          
	 */	
	@FXML
	void onDragDone(DragEvent event) {
		/* the drag and drop gesture ended */
		/* if the data was successfully moved, clear it */
		System.out.println("Inside OnDragDone");
		if (event.getTransferMode() == TransferMode.MOVE) {
			if(target.getImage() != null){
				Piece evolvedPiece =boardController.getEvolvedPiece(source.getId(),target.getId());
				target.setImage(new Image(evolvedPiece.getImagePath()));
				target.setId(evolvedPiece.getId());
			}
			else{
				target.setImage(db.getImage());
				target.setId(source.getId());
			}
			target.setFitWidth(149.0);
			target.setPreserveRatio(true);
			String currenPlayerName = boardController.getCurrentPlayerName();
			currentPlayerText.setText(currenPlayerName);
			event.acceptTransferModes(TransferMode.ANY);
			source.imageProperty().set(null);
		}
		else{
			messageText.setText("Invalid Move.");
		}
		event.consume();
	}

	
	@FXML
	void onMouseClicked(MouseEvent event) {

		/* show available moves for a player */
		source = (ImageView)event.getPickResult().getIntersectedNode();
		for(Location location : boardController.getAvailableMovesForPiece(source.getId())){
			AnchorPane anchorPane = (AnchorPane) getNodeFromGridPane(location.getyCoordinate(),location.getxCoordinate());
			anchorPane.setStyle("-fx-background-color:#ffffff");		}
	}

	/**
	 * 
	 * @param action
	 * 			onSaveButtonClick(ActionEvent) is an event that save the
	 *          current state of the game. 
	 *             
	 */

	@FXML
	public void onSaveButtonClick(ActionEvent action){
		System.out.println("Save clicked");
		boardController.saveGame();
	}
	@FXML
	private void onAttackButtonClicked(ActionEvent action){
		attackButtonClicked = true;
	}
	@FXML
	private void onDefenceButtonClicked(ActionEvent action){
		defenceButtonClicked = true;
	}
	
	/**
	 * 
	 * @param col
	 * @param row
	 * 			getNodeFromGridPane defines the node's row and column index
	 *          in the gridPane. 
	 *             
	 */
	private Node getNodeFromGridPane(int col, int row) {
		for (Node node : gridPane.getChildren()) {
			if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
				return node;
			}
		}
		return null;
	}


}
