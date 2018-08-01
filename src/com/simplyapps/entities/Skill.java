/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

/**
 *
 * @author accusedmonk
 */
public class Skill {
    
    private boolean skillActive;
    private int skillProficiency;
    private String skillName;
    private String affectedBy;
    
    public Skill(){
        
    }

    /**
     *
     * @param skillActive
     * @param skillProficiency
     * @param skillName
     * @param affectedBy
     */
    public Skill(boolean skillActive, int skillProficiency, String skillName, String affectedBy) {
        this.skillActive = skillActive;
        this.skillProficiency = skillProficiency;
        this.skillName = skillName;
        this.affectedBy = affectedBy;
    }
    
    /**
     * @return the skillActive
     */
    public boolean isSkillActive() {
        return skillActive;
    }

    /**
     * @param skillActive the skillActive to set
     */
    public void setSkillActive(boolean skillActive) {
        this.skillActive = skillActive;
    }

    /**
     * @return the skillProficiency
     */
    public int getSkillProficiency() {
        return skillProficiency;
    }

    /**
     * @param skillProficiency the skillProficiency to set
     */
    public void setSkillProficiency(int skillProficiency) {
        this.skillProficiency = skillProficiency;
    }

    /**
     * @return the skillName
     */
    public String getSkillName() {
        return skillName;
    }

    /**
     * @param skillName the skillName to set
     */
    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    
    /**
     *
     * @return
     */
    public String getAffectedBy() {
        return affectedBy;
    }

    /**
     *
     * @param affectedBy
     */
    public void setAffectedBy(String affectedBy) {
        this.affectedBy = affectedBy;
    }
}
