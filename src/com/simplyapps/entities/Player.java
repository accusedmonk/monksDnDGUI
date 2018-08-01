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
        initializePlayer();
    }
    
    public void initializePlayer(){
        
        playerClass = new PlayerClass();
        playerBackground = new PlayerBackground();
        playerRace = new PlayerRace();
        playerStats = new PlayerStats();
        personalityTraits = new ArrayList<String>();
        ideals = new ArrayList<String>();
        bonds = new ArrayList<String>();
        flaws = new ArrayList<String>();
        languages = new ArrayList<String>();
    }
}
