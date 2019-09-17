package com.oosd.model;

import com.oosd.util.Creator;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  Avenger Class invokes the attributes of piece class  				  
* 
*/

public class Avenger extends Piece {

	/** 
	   * Constructor calls the Parent Class Piece.  
	   */
	
	public Avenger() {
		super();
		
	}
	
	/**
	   * 
	   * CONSTRUCTOR
	   * 
	   * @param id  represents individual piece id.  
	   * @param name represents piece name.
	   * @param location represents the piece location.
	   * @param canSustain represent the existence of piece.
	   * @param isAlive represent the life of piece
	   * @param teamName represents the name of the team.
	   * @param imagePath represents the path assigned to image.
	   *			Creates a new object that represents Avenger team.
	   * 
	   */

	/*public Avenger(String id, String name, Location location, Collection<Power> canSustain, boolean isAlive,
			String teamName, String imagePath) {
		super(id, name, location, canSustain, isAlive, teamName, imagePath);
	}*/
	
	
	/**
	   *  
	   * @param caputredPiece  Defines the pieces that are captured during the game.
	   * @param helper  	   Defines the object creation of new piece . 
	   * 			It captures the opposite(XMen) team player piece during the game 
	   * 			and creates the new Batman piece. 
	   */

	@Override
	public Piece capture(Piece capturedPiece, Creator helper) {
		Piece batman = helper.createDynamicBatman(capturedPiece.getLocation());
		Board board = Board.getInstance();
		board.getPieces().remove(capturedPiece);
		board.getPieces().remove(this);
		board.addNewPiece(batman);
		return batman;
	}

}
