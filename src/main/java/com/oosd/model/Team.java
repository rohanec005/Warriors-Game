package com.oosd.model;

import java.util.Collection;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  Class defines the structure of the team. 				  
* 
*/
public class Team {
	
	//Instance Variables
	private Integer id; //Declaration of Team id.
	private String name; //Declaration of Team name.
	private Collection<Piece> pieces; // Declaration of collection of pieces.
	
	/**
	 * Gets the team id
	 *  @return id  
	 */
	
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the team id
	 * @param id
	 */
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the team name
	 * @return name
	 */	
	
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the team name 
	 *  @param name 
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets pieces of the team
	 * @return pieces
	 */
	
	public Collection<Piece> getPieces() {
		return pieces;
	}
	
	/**
	 * Sets pieces of the team
	 * @param pieces 
	 */
	
	public void setPieces(Collection<Piece> pieces) {
		this.pieces = pieces;
	} 
}
