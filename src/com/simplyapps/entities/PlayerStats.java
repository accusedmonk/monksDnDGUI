/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author accusedmonk
 */
public class PlayerStats implements Serializable {
    
    public IntegerProperty maxHitPoints;
    public IntegerProperty currentHitPoints;
    public IntegerProperty experience;
    public IntegerProperty height;
    public IntegerProperty weight;
    public IntegerProperty lifespan;
    public IntegerProperty speed;
    public IntegerProperty deathSuccesses;
    public IntegerProperty deathFailures;
    public StringProperty size;
    
    public IntegerProperty strength;
    public IntegerProperty dexterity;
    public IntegerProperty constitution;
    public IntegerProperty intelligence;
    public IntegerProperty wisdom;
    public IntegerProperty charisma;
    
    public IntegerProperty strengthMod;
    public IntegerProperty dexterityMod;
    public IntegerProperty constitutionMod;
    public IntegerProperty intelligenceMod;
    public IntegerProperty wisdomMod;
    public IntegerProperty charismaMod;
    
    public IntegerProperty passiveWisdom;
    public IntegerProperty proficiencyBonus;
    
    public PlayerStats(){
        
        
    }
    
    public int calcMod(int value){
        return (value-10)/2;
    }

    
    
    
}
