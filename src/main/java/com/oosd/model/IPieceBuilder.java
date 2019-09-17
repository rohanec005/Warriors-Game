package com.oosd.model;

import java.util.Collection;
import com.oosd.model.power.Power;

/**
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption Implementation of Builder pattern 
*             
*/

public interface IPieceBuilder {

	PieceBuilder buildPieceId(String id);
	PieceBuilder buildPieceName(String name);
	PieceBuilder buildPieceLocation(Location location);
	PieceBuilder buildPiecePower(Collection<Power> powers);
	PieceBuilder buildIsAlive(boolean isAlive);
	PieceBuilder buildTeamName(String teamName);
	PieceBuilder buildImagePath(String imagePath);
	/*PieceBuilder buildDefenseMode(boolean isDefenseMode);
	PieceBuilder buildAttackMode(boolean isAttackMode);*/
}
