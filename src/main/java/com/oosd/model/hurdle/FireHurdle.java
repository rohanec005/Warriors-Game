package com.oosd.model.hurdle;

import java.util.List;
import com.oosd.model.HurdleDecorator;
import com.oosd.model.IBoard;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption The FireHurdle class Extends the HurdleDecorator
* 
*/
public class FireHurdle extends HurdleDecorator {

	public FireHurdle(IBoard tempBoard) {
		super(tempBoard);
		
	}

	/**
	 * get the hurdles
	 */
	@Override
	public List<HurdleDecorator> getHurdles() {
		tempBoard.getHurdles().add(this);
		return tempBoard.getHurdles();
	}
}
