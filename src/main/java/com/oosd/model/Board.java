package com.oosd.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.google.java.contract.Requires;
import com.oosd.util.Constants;
import com.oosd.util.Creator;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption The Board Class program creates the new board
* 				   with Pieces and Hurdles
* 
*/

public class Board implements IBoard{

	//Instance Variables
	private List<Piece> pieces; // Declaration of List of Pieces.
	private List<HurdleDecorator> hurdles; // Declaration of Hurdles.
	private static Board board = new Board(); // Create single instance of Board Object (Singleton)

	private Board() {

	}

	/** 
	 * Gets the new board
	 *  @return board
	 */
	public static Board getInstance() {
		return board;
	}

	/**
	 * Gets the list of pieces 
	 *  @return pieces 
	 */
	
	public List<Piece> getPieces() {
		return pieces;
	}

	/**
	 * sets the list of pieces 
	 * @param pieces
	 */
	
	public void setPieces(List<Piece> pieces) {
		this.pieces = pieces;
	}
	
	/**
	 * Gets the list of hurdles 
	 *  @return board
	 */	
	
	@Override
	public List<HurdleDecorator> getHurdles() {
		return hurdles;
	}

	/**
	 * Set the hurdles
	 * @param hurdles
	 */
	
	public void setHurdles(List<HurdleDecorator> hurdles) {
		this.hurdles = hurdles;
	}
	
	/**
	 * Get the new Piece
	 * @param piece
	 */
	
	public void addNewPiece(Piece piece){
		getPieces().add(piece);
	}

	/**
	 * 	
	 * @param id Defines Piece id
	 * @return piece
	 *        Get particular piece by its id.
	 */
	@Requires("!id.isEmpty()")
	public Piece getPieceById(String id) {
		List<Piece> pieces = this.getPieces();
		for (Piece piece : pieces) {
			if (piece.getId().equals(id)) {
				return piece;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param team  Defines the team name
	 * @return teamPieces
	 *              
	 */
	@Requires({"team.equals(Constants.AVENGER) || team.equals(Constants.XMEN)"})
	public List<Piece> getPiecesByTeam(String team) {
		List<Piece> teamPieces = new ArrayList<Piece>();
		teamPieces = getPieces().stream().filter(p -> p.getTeamName().equalsIgnoreCase(team)).collect(Collectors.toList());
		return teamPieces;
	}
	
    /**
     * Display the Combat(attack/defense) ability of Either team
     * @param team
     */
	
	public void disableOpponentCombatAbility(String team) {
		List<Piece> teamPieces = new ArrayList<Piece>();
		teamPieces = getPieces().stream().filter(p -> !p.getTeamName().equalsIgnoreCase(team)).collect(Collectors.toList());
		
		for(Piece piece:teamPieces){
			System.out.println("Before enable Piece : "+piece.getName()+ " "+ piece.isAttackModeEnabled() +" "+ piece.isDefenceModeEnabled());
			if (piece.isDefenceModeEnabled()) {
				piece.disableDefenceMode();
			}
			if (piece.isAttackModeEnabled()) {
				piece.disableAttackMode();
			}
		}
	}
	
	
	/**
	 * 
	 * @param capturingPieceId  Defines the id of the Capturing piece.
	 * @param opponentPieceId   Defines the if of the Opponent piece.
	 * @return evolvedPiece     Return new piece after the capture
	 *        Dynamically creates Superman or Batman Piece when the existing 
	 * 		  Piece is captured by Opponent. 
	 */
	public Piece captureOpponentPlayer(String capturingPieceId,String opponentPieceId){
		Piece evolvedPiece;
		Piece opponentPiece = getPieceById(opponentPieceId);
		 if(opponentPiece.getTeamName().equalsIgnoreCase(Constants.AVENGER)){
			 evolvedPiece = Creator.getInstance().createDynamicSuperman(opponentPiece.getLocation());
		 }
		 else{
			 evolvedPiece = Creator.getInstance().createDynamicBatman(opponentPiece.getLocation());
		 }
		 pieces.add(evolvedPiece);
		 System.out.println("On remove result1:"+getPieces().remove(getPieceById(capturingPieceId)));
		 System.out.println("On remove result2:"+getPieces().remove(opponentPiece));
		 return evolvedPiece;
	}
}