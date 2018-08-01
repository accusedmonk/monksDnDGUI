/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import java.util.List;


/**
 *
 * @author accusedmonk
 */

public class Player implements Serializable {
    
    private String playerName;
    private PlayerClass playerClass;
    private PlayerBackground playerBackground;
    private PlayerRace playerRace;
    private PlayerStats playerStats;
    
    private List<String> personalityTraits;
    private List<String> ideals;
    private List<String> bonds;
    private List<String> flaws;
    private List<String> languages;
}
