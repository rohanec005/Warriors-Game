package com.oosd.model;

import java.util.Collection;

import com.oosd.model.power.Power;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDesciption Implementation of Builder Pattern
* 
*/
public class PieceBuilder implements IPieceBuilder {

	Piece piece;

	public PieceBuilder createPiece(Piece piece) {
		this.piece = piece;
		return this;
	}

	@Override
	public PieceBuilder buildPieceId(String id) {
		piece.setId(id);
		return this;
	}

	@Override
	public PieceBuilder buildPieceName(String name) {
		piece.setName(name);
		return this;
	}

	@Override
	public PieceBuilder buildPieceLocation(Location location) {
		piece.setLocation(location);
		return this;
	}

	@Override
	public PieceBuilder buildPiecePower(Collection<Power> powers) {
		piece.setPowers(powers);
		return this;
	}

	@Override
	public PieceBuilder buildIsAlive(boolean isAlive) {
		piece.setAlive(isAlive);
		return this;
	}

	@Override
	public PieceBuilder buildTeamName(String teamName) {
		piece.setTeamName(teamName);
		return this;
	}

	@Override
	public PieceBuilder buildImagePath(String imagePath) {
		piece.setImagePath(imagePath);
		return this;
	}

/*	@Override
	public PieceBuilder buildDefenseMode(boolean isDefenseMode) {
		piece.isDefenceModeEnabled(isDefenseMode);
		return this;
	}

	@Override
	public PieceBuilder buildAttackMode(boolean isAttackMode) {

		return null;
	}*/
	
	public Piece getPiece (){
		return piece;
	}

}
