/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;

/**
 *
 * @author accusedmonk
 */
public class Skill implements Serializable {
    
    private boolean enabled;
    private int proficiency;
    private String skill;
    private String affectedBy;
    
    public Skill(){
        
    }

    /**
     *
     * @param enabled
     * @param proficiency
     * @param name
     * @param affectedBy
     */
    public Skill(boolean enabled, int proficiency, String name, String affectedBy) {
        this.enabled = enabled;
        this.proficiency = proficiency;
        this.skill = name;
        this.affectedBy = affectedBy;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getProficiency() {
        return proficiency;
    }

    public void setProficiency(int proficiency) {
        this.proficiency = proficiency;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getAffectedBy() {
        return affectedBy;
    }

    public void setAffectedBy(String affectedBy) {
        this.affectedBy = affectedBy;
    }
    
    
}
