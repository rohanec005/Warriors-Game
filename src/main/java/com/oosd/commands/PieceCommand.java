package com.oosd.commands;

import java.util.List;

import com.oosd.model.Location;
import com.oosd.model.Piece;

/**
* 
* @author  Nidhi Chawla
* @version 1.0
* @classDescription PieceCommand pattern implements using command class.
* 
*/

public class PieceCommand implements Command {
	
	//Instace variables
	private Piece piece ; //Declaration of piece reference object of class Piece.
	private Location destination; // Declaration of destination variable of Location class.
	private List<Piece> pieces; // Declaration of pieces list.
	private Action action; // Declaration of action variable of class Action.

	/**
	 * enum Declaration 
	 */
	public enum Action {
		MOVE
	}
	
	/**
	   * 
	   * CONSTRUCTOR
	   * 
	   * @param pieceToBeMoved  represents the moving piece  
	   * @param destination     represents the destination location.
	   * @param action          represents the action.
	   * @param pieces          represent the existence of piece.
	   *			      Creates a new object that represents the Piece.
	   * 
	   */
	public PieceCommand(Piece pieceToBeMoved, Location destination, Action action, List<Piece> pieces) {
		super();
		this.piece = pieceToBeMoved;
		this.destination = destination;
		this.action = action;
		this.pieces = pieces;
	}

	/** 
	 * Movement of Pieces to destination 
	 * 
	 */
	
	@Override
	public boolean execute() {
		boolean resultOfCommand = false;
		switch(action){
		case MOVE:
			resultOfCommand = piece.move(destination, pieces);
			break;
		}
		return resultOfCommand;
	}

}
