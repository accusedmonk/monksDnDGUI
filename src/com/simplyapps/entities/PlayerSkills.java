/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.util.List;

/**
 *
 * @author accusedmonk
 */
public class PlayerSkills {
    
    List<Skill> skills;
    
    public PlayerSkills(){
        
        initializeSkills();
    }
    
    private void initializeSkills(){
        
        skills.add(new Skill(false, 0, "Acrobatics",        "Dexterity"));
        skills.add(new Skill(false, 0, "Animal Handling",   "Wisdom"));
        skills.add(new Skill(false, 0, "Arcana",            "Intelligence"));
        skills.add(new Skill(false, 0, "Athletics",         "Strength"));
        skills.add(new Skill(false, 0, "Deception",         "Charisma"));
        skills.add(new Skill(false, 0, "History",           "Intelligence"));
        skills.add(new Skill(false, 0, "Insight",           "Wisdom"));
        skills.add(new Skill(false, 0, "Intimidation",      "Charisma"));
        skills.add(new Skill(false, 0, "Investigation",     "Intelligence"));
        skills.add(new Skill(false, 0, "Medicine",          "Wisdom"));
        skills.add(new Skill(false, 0, "Nature",            "Intelligence"));
        skills.add(new Skill(false, 0, "Perception",        "Wisdom"));
        skills.add(new Skill(false, 0, "Performance",       "Charisma"));
        skills.add(new Skill(false, 0, "Persuasion",        "Charisma"));
        skills.add(new Skill(false, 0, "Religion",          "Intelligence"));
        skills.add(new Skill(false, 0, "Sleight of Hand",   "Dexterity"));
        skills.add(new Skill(false, 0, "Stealth",           "Dexterity"));
        skills.add(new Skill(false, 0, "Survival",          "Wisdom"));
    }
}
