package com.oosd.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.oosd.model.Board;
import com.oosd.model.Game;
import com.oosd.model.Location;
import com.oosd.model.Piece;
import com.oosd.model.PieceBuilder;
import com.oosd.model.Player;
import com.oosd.model.piece.newform.Batman;
import com.oosd.model.piece.newform.Superman;
import com.oosd.model.power.Power;
import com.oosd.model.power.SelfHealingPower;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  This class creates the main objects requires .   				  
* 					 to setup and run the game.
*/

public class Creator {
	
	private static Creator creator; // Declaration of creator reference object of Creator Class
	
	private Creator(){
		
	}
	
	/**
	 * 
	 * @return creator
	 */
	public synchronized static Creator getInstance(){
		if(creator == null){
			return new Creator();
		}
		return creator;
	}
	
	/**
	 * 
	 * @param location
	 * @return piece
	 * This class Dynamically creates the Superman Piece
	 */

	public Piece createDynamicSuperman(Location location) {
		Collection<Power> superManPowers = new ArrayList<Power>();
		superManPowers.add(new SelfHealingPower());
		return new PieceBuilder().createPiece(new Superman())
						.buildPieceId(Constants.ID_SUPERMAN+UUID.randomUUID().toString())
						.buildPieceName(Constants.SUPERMAN)
						.buildPieceLocation(location)
						.buildPiecePower(superManPowers)
						.buildIsAlive(true)
						.buildTeamName(Constants.XMEN)
						.buildImagePath(Constants.SUPERMAN_IMAGE)
						.getPiece();
	}

	/**
	 * 
	 * @param location Defines the location reference object
	 * @return piece
	 * This class Dynamically creates the Batman Piece
	 */
	public Piece createDynamicBatman(Location location) {
		Collection<Power> batManPowers = new ArrayList<Power>();
		batManPowers.add(new SelfHealingPower());

		return new PieceBuilder().createPiece(new Batman())
				.buildPieceId(Constants.ID_BATMAN+UUID.randomUUID().toString())
				.buildPieceName(Constants.BATMAN)
				.buildPieceLocation(location)
				.buildPiecePower(batManPowers)
				.buildIsAlive(true)
				.buildTeamName(Constants.AVENGER)
				.buildImagePath(Constants.BATMAN_IMAGE)
				.getPiece();
	}
	
	/**
	 * 
	 * This method create the board and 
	 * dynamically allot the players into the teams.
	 * @return board
	 */

	public Board createBoard() {

/*		Board board = Board.getInstance();
		Player player1 = new Player(1, 0.0, Constants.AVENGER);
		Player player2 = new Player(2, 0.0, Constants.XMEN);
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		Game game = Game.getInstance();
		game.setBoard(board);
		game.setPlayers(players);
		game.setCurrentPlayer(game.getPlayers().get(0));
		Collection<IXMenPower> wolverinePowers = new ArrayList<IXMenPower>();
		wolverinePowers.add(new SelfHealingPower());
		Collection<IXMenPower> jeanPowers = new ArrayList<IXMenPower>();
		jeanPowers.add(new SelfHealingPower());
		Collection<IXMenPower> magnetoPowers = new ArrayList<IXMenPower>();
		magnetoPowers.add(new SelfHealingPower());
		Collection<IXMenPower> charlesPowers = new ArrayList<IXMenPower>();
		charlesPowers.add(new SelfHealingPower());

		Collection<IXMenPower> hulkPowers = new ArrayList<IXMenPower>();
		charlesPowers.add(new SelfHealingPower());

		Collection<IXMenPower> blackWidowPowers = new ArrayList<IXMenPower>();
		charlesPowers.add(new SelfHealingPower());

		Collection<IXMenPower> thorPowers = new ArrayList<IXMenPower>();
		charlesPowers.add(new SelfHealingPower());
		Collection<IXMenPower> ironManPowers = new ArrayList<IXMenPower>();
		charlesPowers.add(new SelfHealingPower());

		Piece charlesXavier = new CharlesXavier(Constants.ID_CHARLES, Constants.CHARLES, new Location(1, 5),
				charlesPowers, true, Constants.XMEN, Constants.CHARLES_XAVIER_IMAGE);

		Piece wolverine1 = new Wolverine(Constants.ID_WOLVERINE1, Constants.WOLVERINE, new Location(1, 1),
				wolverinePowers, true, Constants.XMEN, Constants.WOLVERINE_IMAGE);
		Piece wolverine2 = new Wolverine(Constants.ID_WOLVERINE2, Constants.WOLVERINE, new Location(1, 6),
				wolverinePowers, true, Constants.XMEN, Constants.WOLVERINE_IMAGE);
		Piece wolverine3 = new Wolverine(Constants.ID_WOLVERINE3, Constants.WOLVERINE, new Location(1, 7),
				wolverinePowers, true, Constants.XMEN, Constants.WOLVERINE_IMAGE);
		Piece jean1 = new Jean(Constants.ID_JEAN1, Constants.JEAN, new Location(1, 10), jeanPowers, true,
				Constants.XMEN, Constants.JEAN_IMAGE);
		Piece jean2 = new Jean(Constants.ID_JEAN2, Constants.JEAN, new Location(1, 4), jeanPowers, true,
				Constants.XMEN, Constants.JEAN_IMAGE);
		Piece jean3 = new Jean(Constants.ID_JEAN3, Constants.JEAN, new Location(1, 8), jeanPowers, true,
				Constants.XMEN, Constants.JEAN_IMAGE);
		Piece magneto1 = new Magneto(Constants.ID_MAGNETO1, Constants.MAGNETO, new Location(1, 2), magnetoPowers,
				true, Constants.XMEN, Constants.MAGNETO_IMAGE);
		Piece magneto2 = new Magneto(Constants.ID_MAGNETO2, Constants.MAGNETO, new Location(1, 3), magnetoPowers,
				true, Constants.XMEN, Constants.MAGNETO_IMAGE);
		Piece magneto3 = new Magneto(Constants.ID_MAGNETO3, Constants.MAGNETO, new Location(1, 9), magnetoPowers,
				true, Constants.XMEN, Constants.MAGNETO_IMAGE);

		Piece hulk1 = new Hulk(Constants.ID_HULK1, Constants.HULK, new Location(8, 1), hulkPowers, true,
				Constants.AVENGER, Constants.HULK_IMAGE);
		Piece hulk2 = new Hulk(Constants.ID_HULK2, Constants.HULK, new Location(8, 6), hulkPowers, true,
				Constants.AVENGER, Constants.HULK_IMAGE);
		Piece hulk3 = new Hulk(Constants.ID_HULK3, Constants.HULK, new Location(8, 9), hulkPowers, true,
				Constants.AVENGER, Constants.HULK_IMAGE);

		Piece blackwidow1 = new BlackWidow(Constants.ID_BLACKWIDOW1, Constants.BLACKWIDOW, new Location(8, 10),
				blackWidowPowers, true, Constants.AVENGER, Constants.BLACK_WIDOW_IMAGE);
		Piece blackwidow2 = new BlackWidow(Constants.ID_BLACKWIDOW2, Constants.BLACKWIDOW, new Location(8, 3),
				blackWidowPowers, true, Constants.AVENGER, Constants.BLACK_WIDOW_IMAGE);
		Piece blackwidow3 = new BlackWidow(Constants.ID_BLACKWIDOW3, Constants.BLACKWIDOW, new Location(8, 8),
				blackWidowPowers, true, Constants.AVENGER, Constants.BLACK_WIDOW_IMAGE);

		Piece thor1 = new Thor(Constants.ID_THOR1, Constants.THOR, new Location(8, 2), thorPowers, true,
				Constants.AVENGER, Constants.THOR_IMAGE);
		Piece thor2 = new Thor(Constants.ID_THOR2, Constants.THOR, new Location(8, 4), thorPowers, true,
				Constants.AVENGER, Constants.THOR_IMAGE);
		Piece thor3 = new Thor(Constants.ID_THOR3, Constants.THOR, new Location(8, 7), thorPowers, true,
				Constants.AVENGER, Constants.THOR_IMAGE);

		Piece ironman = new IronMan(Constants.ID_IRONMAN, Constants.IRONMAN, new Location(8, 5), ironManPowers,
				true, Constants.AVENGER, Constants.IRONMAN_IMAGE);

		List<Piece> pieces = Arrays.asList(wolverine1, wolverine2, wolverine3, jean1, jean2, jean3, magneto1, magneto2,
				magneto3, charlesXavier, hulk1, hulk2, hulk3, blackwidow1, blackwidow2, blackwidow3, thor1, thor2,
				thor3, ironman);
		board.setPieces(pieces);*/
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		Board board = null;
		try {
			board = mapper.readValue(new File("src/main/resources/game_state/board.json"), Board.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Player player1 = new Player(1, 0.0, Constants.AVENGER);
		Player player2 = new Player(2, 0.0, Constants.XMEN);
		List<Player> players = new ArrayList<>();
		players.add(player1);
		players.add(player2);
		Game game = Game.getInstance();
		game.setBoard(board);
		game.setPlayers(players);
		game.setCurrentPlayer(game.getPlayers().get(0));
		
		// Convert object to JSON string and save into a file directly
		/*  ObjectMapper mapper = new ObjectMapper();
			mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			mapper.writeValue(new File("src/main/resources/game_state/board.json"), board);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		return board;	
	}
	
}