/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


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
    
    ObservableList<String> personalityTraits;
    ObservableList<String> ideals;
    ObservableList<String> bonds;
    ObservableList<String> flaws;
    ObservableList<String> languages;
    
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
        personalityTraits = FXCollections.observableArrayList();
        ideals = FXCollections.observableArrayList();
        bonds = FXCollections.observableArrayList();
        flaws = FXCollections.observableArrayList();
        languages = FXCollections.observableArrayList();
    }
    
}
