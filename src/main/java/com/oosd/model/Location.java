package com.oosd.model;

public class Location {
	
	/**
	* 
	* @author  Siddharth Sachdeva
	* @version 1.0
	* @classDesciption The Location Class program defines the coordinates  
	* 				   of the piece.
	* 
	*/
	
	//Instance variables
	private int xCoordinate; // Declaration of X coordinate
	private int yCoordinate; // Declaration of y coordinate
	
	public Location() {
		super();

	}

	/**
	   * CONSTRUCTOR
	   * 
	   * @param xCoordinate represents the X coordinate.  
	   * @param yCoordinate represents the Y coordinate.
	   * 
	   */
	public Location(int xCoordinate, int yCoordinate) {
		super();
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	/**
	 * Gets the xCoordinate
	 *  @return xCoordinate 
	 */
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	/**
	 * 
	 * Sets the xCoordinate 
	 * @param xCoordinate
	 * 
	 */
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	/**
	 * Gets the coordinates 
	 *  @return yCoordinate 
	 */
	
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	/**
	 * sets the coordinates  
	 * @param yCoordinate
	 */
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
}
