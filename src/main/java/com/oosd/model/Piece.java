package com.oosd.model;

import java.util.ArrayList;
import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.java.contract.Requires;
import com.oosd.model.piece.avenger.BlackWidow;
import com.oosd.model.piece.avenger.Hulk;
import com.oosd.model.piece.avenger.IronMan;
import com.oosd.model.piece.avenger.Thor;
import com.oosd.model.piece.newform.Batman;
import com.oosd.model.piece.newform.Superman;
import com.oosd.model.piece.xmen.CharlesXavier;
import com.oosd.model.piece.xmen.Jean;
import com.oosd.model.piece.xmen.Magneto;
import com.oosd.model.piece.xmen.Wolverine;
import com.oosd.model.power.Power;
import com.oosd.util.Constants;
import com.oosd.util.Creator;

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  This class assigns the player attributes of the game               
* 
*/


@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Avenger.class, name = "Avenger"),
    @JsonSubTypes.Type(value = XMen.class, name = "XMen"),
    @JsonSubTypes.Type(value = BlackWidow.class, name = "BlackWidow"),
    @JsonSubTypes.Type(value = Hulk.class, name = "Hulk"),
    @JsonSubTypes.Type(value = IronMan.class, name = "IronMan"),
    @JsonSubTypes.Type(value = Thor.class, name = "Thor"),
    @JsonSubTypes.Type(value = CharlesXavier.class, name = "CharlesXavier"),
    @JsonSubTypes.Type(value = Jean.class, name = "Jean"),
    @JsonSubTypes.Type(value = Magneto.class, name = "Magneto"),
    @JsonSubTypes.Type(value = Wolverine.class, name = "Wolverine"),
    @JsonSubTypes.Type(value = Batman.class, name = "Batman"),
    @JsonSubTypes.Type(value = Superman.class, name = "Superman")}
)
public abstract class Piece {

	//Instance Variables 
	private String id; // Declaration of Piece id.
	private String name; // Declaration of Piece name
	private Location location; // Declaration of location reference object of class Board. 
	private Collection<Power> powers;
	private boolean isAlive; //Declaration of 
	private String teamName;
	private String imagePath;
	private boolean defenceMode;
	private boolean attackMode;
	
	public Piece() {
		super();
	}

	/*public Piece(String id, String name, Location location, Collection<Power> powers, boolean isAlive,
			String teamName, String imagePath) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.powers = powers;
		this.isAlive = isAlive;
		this.teamName = teamName;
		this.imagePath = imagePath;
		this.defenceMode = false;
		this.attackMode = false;
	}*/

	public abstract Piece capture(Piece capturedPiece, Creator helper);

	/**
	 * 
	 */
	@Override
	protected Piece clone() {
		try {
			return (Piece) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Get the Piece Image Path
	 * @return imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * Set the piece Image Path
	 * @param imagePath
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	/**
	 * Get the piece id 
	 * @return id
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Set the Piece id
	 * @param id
	 */

	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * get the piece name
	 * @return name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * Set the piece name
	 * @param name
	 */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the piece location
	 * @return location
	 */

	public Location getLocation() {
		return location;
	}
	
	/**
	 * set the piece Location
	 * @param location
	 */

	public void setLocation(Location location) {
		this.location = location;
	}
	
	/**
	 * get the powers of piece
	 * @return powers
	 */

	public Collection<Power> getPowers() {
		return powers;
	}

	/**
	 * Set the Powers of Piece
	 * @param powers
	 */
	
	public void setPowers(Collection<Power> powers) {
		this.powers = powers;
	}

	/**
	 * 
	 * @return isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public void activateDefenceMode(){
		this.defenceMode=true;
	}
	public void activateAttackMode(){
		this.attackMode=true;
	}
	public void disableDefenceMode(){
		this.defenceMode=false;
	}
	public void disableAttackMode(){
		this.attackMode=false;
	}
	public boolean isDefenceModeEnabled() {
		return defenceMode;
	}

	public boolean isAttackModeEnabled() {
		return attackMode;
	}
	
	/**
	 * 
	 * @param destination Defines the destination location of piece.
	 * @param pieces      Defines the collection of pieces
	 * @return true
	 *                This method first validates the move of each piece by
	 *                checking whether the piece is moved  within same location or 
	 *                Whether the piece is trying to move from more than one location or
	 *                checks whether the same team piece is moved twice.  
	 *                After the following condition validated the piece is moved. 
	 */
	
	
	// Method to move a piece only if it is valid.
	@Requires("destination.xCoordinate = piece.getLocation().getxCoordinate+1 || destination.yCoordinate = piece.getLocation().getyCoordinate+1")
	public boolean move(Location destination, Collection<Piece> pieces) {

		if (!Game.getInstance().getCurrentPlayer().getName().equals(this.getTeamName())) {
			return false;
		}

		boolean isSameLocation = this.getLocation().getxCoordinate() == destination.getxCoordinate()
				&& this.getLocation().getyCoordinate() == destination.getyCoordinate();
		
		
		boolean isWrongMoveAtXCordinate = destination.getxCoordinate() > this.getLocation().getxCoordinate() + 1 || destination.getxCoordinate() < this.getLocation().getxCoordinate() - 1;
		boolean isWrongMoveAtYCordinate = destination.getyCoordinate() > this.getLocation().getyCoordinate() + 1
				|| destination.getyCoordinate() < this.getLocation().getyCoordinate() - 1;
		
		if (isSameLocation) {
			return false;
		} else if (isWrongMoveAtXCordinate || isWrongMoveAtYCordinate) {
			return false;
		} else {
			Collection<Piece> validateOnPieces = new ArrayList<Piece>(pieces);
			validateOnPieces.remove(this);
			for (Piece currentPiece : validateOnPieces) {
				boolean isSameTeam = this.getTeamName().equalsIgnoreCase(currentPiece.getTeamName()); 
				if (isSameTeam) {
					boolean movingOnSameTeamMember = currentPiece.getLocation().getxCoordinate() == destination.getxCoordinate()
							&& currentPiece.getLocation().getyCoordinate() == destination.getyCoordinate();
					if (movingOnSameTeamMember) {
						return false;
					}
				}
			}
		}
		this.setLocation(destination);
		return true;
	}

	/**
	 * 
	 * @param pieces Defines the collection of pieces
	 * @return possibleLocations
	 *               This method get all the possible moves of the pieces 
	 *               by validating the move from current piece location. 
	 */


	public Collection<Location> getAvailableMoves(Collection<Piece> pieces) {
		Collection<Location> possibleLocations = new ArrayList<>();
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate()));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate()));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate(), this.getLocation().getyCoordinate() + 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate(), this.getLocation().getyCoordinate() - 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate() + 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate() - 1));
		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() + 1, this.getLocation().getyCoordinate() - 1));

		possibleLocations
				.add(new Location(this.getLocation().getxCoordinate() - 1, this.getLocation().getyCoordinate() + 1));
		Collection<Piece> validateOnPieces = new ArrayList<Piece>(pieces);
		validateOnPieces.remove(this);
		Collection<Location> temporaryPossibleLocations = new ArrayList<>(possibleLocations);
		for (Location location : temporaryPossibleLocations) {
			for (Piece currentPiece : validateOnPieces) {
				boolean isSameTeamPlayer = this.getTeamName().equalsIgnoreCase(currentPiece.getTeamName());
				if (isSameTeamPlayer) {
					if (currentPiece.getLocation().getxCoordinate() == location.getxCoordinate()
							&& currentPiece.getLocation().getyCoordinate() == location.getyCoordinate()) {
						possibleLocations.remove(location);
					}
				}
				//if it is first or last row
				//if it is first or last column 
				if(location.getyCoordinate()<Constants.MIN_COLUMN || location.getyCoordinate()>Constants.MAX_COLUMN) {
					possibleLocations.remove(location);
				}
				else if(location.getxCoordinate()<Constants.MIN_ROW || location.getxCoordinate()>Constants.MAX_ROW) {
					possibleLocations.remove(location);
				}
			}
		}
		return possibleLocations;
	}
}
