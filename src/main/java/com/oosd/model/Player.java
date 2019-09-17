package com.oosd.model;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  This class assigns the player attributes of the game               
* 
*/

public class Player {
	
	//Instance variables
	private int id; // Declaration of Player id
	private double score; // Declaration of Player score
	private String name; // Declaration of Player Name
	
	public Player(){
		
	}
	
	/**
	 * CONSTRUCTOR
	 * 
	 * @param id: id of the Player
	 * @param score: Score of the Player
	 * @param name: name of the player
	 * 
	 */
	
	public Player(int id, double score, String name) {
		super();
		this.id = id;
		this.score = score;
		this.name = name;
	}
	
	/**
	 * Gets the player name
	 *  @return name 
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * sets the player name
	 * @param name
	 */
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the player id
	 * @return id
	 */
	
	public int getId() {
		return id;
	}
	
	/**
	 * sets the player id
	 * @param id
	 */
	
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Gets the player score
	 * @return score
	 */
	
	public double getScore() {
		return score;
	}
	
	/**
	 * Sets the player Score
	 * @param score
	 */
	
	public void setScore(double score) {
		this.score = score;
	}
	
	
}
