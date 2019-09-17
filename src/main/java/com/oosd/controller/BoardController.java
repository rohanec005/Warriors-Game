package com.oosd.controller;

import java.util.Collection;
import java.util.List;

import com.oosd.commands.PieceCommand;
import com.oosd.model.Board;
import com.oosd.model.Game;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.util.Creator;

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
public class  BoardController{
	Board board;// Declaration of instance object of Board class.
	Game game = Game.getInstance();// Create single instance of Game class.
	PieceCommand commandForPiece;//Declaration of instance object of Board class
	private static BoardController boardController = new BoardController(); // Create single instance of BoardController Object (Singleton)
	
	private BoardController() {
	}
	
	/** 
	 * get the instance of BoardController
	 * @return boardController
	 */
	public static BoardController getInstance() {
		return boardController;
	}
	
	/**
	 * Creates single instance of Board class
	 */
	
	public void createBoard() {
		board = Creator.getInstance().createBoard();
	}
	
	/**
	 * 
	 * @param attackButtonClicked   Defines attack click event
	 * @param defenceButtonClicked  Defines Defense click event
	 * @param pieceId               Defines id of the piece
	 * @param destination           Defines Destination of piece.
	 * @return isValidMove          Defines valid move
	 *                  Move method .
	 * 
	 */       
	
	public boolean move(boolean attackButtonClicked, boolean defenceButtonClicked, String pieceId, Location destination) {
		
		Piece piece = board.getPieceById(pieceId);
		commandForPiece = new PieceCommand(piece, destination, PieceCommand.Action.MOVE, board.getPieces());
		boolean isValidMove = commandForPiece.execute();
		if(isValidMove){
			board.disableOpponentCombatAbility(piece.getTeamName());	
			game.toggleTurn();
			if(attackButtonClicked){
				piece.activateAttackMode();
			}
			if(defenceButtonClicked){
				piece.activateDefenceMode();
			}
		}
		
		return isValidMove;
	}
	
	/**
	 * Get the current player name
	 * @return name
	 */
	public String getCurrentPlayerName() {
		
		return game.getCurrentPlayer().getName();
	}
	
	/**
	 * Saves the Game State 
	 */
	public void saveGame() {
		game.saveGame();
	}
	
	
	/**
	 * Gets the board Pieces
	 * @return pieces
	 */
	public List<Piece> getPieces() {
		return board.getPieces();
	}
	
	/**
	 * 
	 * @param  pieceId get the piece id
	 * @return possibleLocations
	 *         Get all possible moves for the Piece
	 *         
	 *         
	 */
	public Collection<Location> getAvailableMovesForPiece(String pieceId) {
		Piece piece = board.getPieceById(pieceId);
		Collection<Location> possibleLocations = piece.getAvailableMoves(board.getPieces());
		return possibleLocations;
		
	}
	
	/**
	 * @param sourceId get source id of piece 
	 * @param targetId get target id of piece
	 * @return evolvedPiece 
	 * 				   Method forms the evolved piece after Capturing 
	 *                 the Opponent Player. 			        
	 */
	public Piece getEvolvedPiece(String sourceId, String targetId) {
		Piece evolvedPiece = board.captureOpponentPlayer(sourceId,targetId);
		return evolvedPiece;
	}
}