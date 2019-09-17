package com.oosd.model.power;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.oosd.model.Avenger;
import com.oosd.model.XMen;
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

/**
* 
* @author  Siddharth Sachdeva
* @version 1.0
* @classDescription  Power Class 
* 					  				  
*/

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
    @JsonSubTypes.Type(value = SelfHealingPower.class, name = "SelfHealingPower")}
)

public interface Power {
	
	void controlMindAttack();
	void magnetismAttack();
	void wealthAttack();
	void clawsAttack();
	
}
