/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author accusedmonk
 */

public class Player implements Serializable {
    
    public String playerName;
    public String characterName;
    public PlayerClass playerClass;
    public PlayerBackground playerBackground;
    public PlayerRace playerRace;
    public PlayerStats playerStats;
    public PlayerSkills playerSkills;
    
    List<String> personalityTraits;
    List<String> ideals;
    List<String> bonds;
    List<String> flaws;
    List<String> languages;
    
    public Player(){
        
        initializeNewPlayer();
    }
    
    public void initializeNewPlayer(){
        
        playerName = "";
        characterName = "";
        playerClass = new PlayerClass();
        playerBackground = new PlayerBackground();
        playerRace = new PlayerRace();
        playerStats = new PlayerStats();
        playerSkills = new PlayerSkills();
        
        personalityTraits = new ArrayList<String>();
        ideals = new ArrayList<String>();
        bonds = new ArrayList<String>();
        flaws = new ArrayList<String>();
        languages = new ArrayList<String>();
    }
    
    public void loadExistingPlayer(){
        
        
    }
}
