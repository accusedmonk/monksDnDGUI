/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
        
        initializeProperties();
    }
    
    public int calcMod(int value){
        return (value-10)/2;
    }

    private void initializeProperties(){
        
        maxHitPoints = new SimpleIntegerProperty();
        currentHitPoints = new SimpleIntegerProperty();
        experience = new SimpleIntegerProperty();
        height = new SimpleIntegerProperty();
        weight = new SimpleIntegerProperty();
        lifespan = new SimpleIntegerProperty();
        speed = new SimpleIntegerProperty();
        deathSuccesses = new SimpleIntegerProperty();
        deathFailures = new SimpleIntegerProperty();
        size = new SimpleStringProperty();

        strength = new SimpleIntegerProperty();
        dexterity = new SimpleIntegerProperty();
        constitution = new SimpleIntegerProperty();
        intelligence = new SimpleIntegerProperty();
        wisdom = new SimpleIntegerProperty();
        charisma = new SimpleIntegerProperty();

        strengthMod = new SimpleIntegerProperty();
        dexterityMod = new SimpleIntegerProperty();
        constitutionMod = new SimpleIntegerProperty();
        intelligenceMod = new SimpleIntegerProperty();
        wisdomMod = new SimpleIntegerProperty();
        charismaMod = new SimpleIntegerProperty();

        passiveWisdom = new SimpleIntegerProperty();
        proficiencyBonus = new SimpleIntegerProperty();
    }
    
    
}
