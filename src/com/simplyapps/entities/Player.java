/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author accusedmonk
 */

public class Player implements Serializable {
    
    public StringProperty playerName;
    public StringProperty characterName;
    public PlayerClass playerClass;
    public PlayerBackground playerBackground;
    public PlayerRace playerRace;
    public PlayerStats playerStats;
    
    List<String> personalityTraits;
    List<String> ideals;
    List<String> bonds;
    List<String> flaws;
    List<String> languages;
    
    public Player(){
        
        initializeNewPlayer();
    }
    
    public void initializeNewPlayer(){
        
        playerName = new SimpleStringProperty();
        playerName.setValue("");
        characterName = new SimpleStringProperty();
        characterName.setValue("");
        playerClass = new PlayerClass();
        playerBackground = new PlayerBackground();
        playerRace = new PlayerRace();
        playerStats = new PlayerStats();
        personalityTraits = new ArrayList();
        ideals = new ArrayList();
        bonds = new ArrayList();
        flaws = new ArrayList();
        languages = new ArrayList();
    }
    
}
