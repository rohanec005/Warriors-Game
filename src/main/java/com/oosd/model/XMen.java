package com.oosd.model;

import java.util.Collection;

import com.oosd.util.Creator;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  XMen class invokes the attributes of piece class  				  
* 
*/

public class XMen extends Piece{

	/**
	   * Constructor calls the Parent Class Piece.
	   *  
	   */
	
	public XMen() {
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
	   *			Creates a new object that represents XMen team.
	   * 
	   */
	
	/*public XMen(String id, String name, Location location, Collection<Power> canSustain, boolean isAlive,
			String teamName, String imagePath) {
		super(id, name, location, canSustain, isAlive, teamName, imagePath);
	}*/

	Collection<Piece> pieces;

	/**
	 * get the Pieces
	 * @return
	 */
	public Collection<Piece> getPieces() {
		return pieces;
	}

	/**
	 * Set the Pieces
	 * @param pieces
	 */
	public void setPieces(Collection<Piece> pieces) {
		this.pieces = pieces;
	}

	
	/**
	   *  
	   * @param caputredPiece  Defines the pieces that are captured during the game.
	   * @param helper  	   Defines the object creation of new piece . 
	   * 			It captures the opposite(XMen) team player piece 
	   * 			and creates the new Superman piece. 
	   */
	
	@Override
	public Piece capture(Piece capturedPiece, Creator helper) {
		Piece superman = helper.createDynamicSuperman(capturedPiece.getLocation());
		Board board = Board.getInstance();
		board.getPieces().remove(capturedPiece);
		board.getPieces().remove(this);
		board.addNewPiece(superman);
		return superman;
	}

	
}
