package com.oosd.model;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption Implementation of HurdleDecorator pattern 
*             
*/


public abstract class HurdleDecorator implements IBoard {
	
	protected IBoard tempBoard;

	public HurdleDecorator(IBoard tempBoard) {
		this.tempBoard = tempBoard;
	}
			
}
