package com.oosd.model.piece.newform;

import com.oosd.model.Board;
import com.oosd.model.Piece;
import com.oosd.model.XMen;
import com.oosd.util.Creator;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  Superman Class invokes the attributes of XMen class
* 					 This is invoked when the opposite player piece is captured.  				  
* 
*/
public class Superman extends XMen {

	
	/** 
	  * Constructor calls the Parent Class XMen.  
	  */
	public Superman() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public Superman(String id, String name, Location location, Collection<Power> canSustain, boolean isAlive, String teamName, String imagePath) {
		super(id, name, location, canSustain, isAlive, teamName, imagePath);
	}*/

	/**
	   *  
	   * @param caputredPiece  Defines the piece that are captured during the game.
	   * @param helper         Defines the object creation of new piece . 
	   * 			It captures the Opposite(Avenger) team player piece during the game 
	   * 			and creates the new piece. 
	   */
	@Override
	public Piece capture(Piece capturedPiece, Creator helper) {
		Board board = Board.getInstance();
		board.getPieces().remove(capturedPiece);
		return this;
	}

	

}
