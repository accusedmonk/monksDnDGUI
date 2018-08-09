/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author accusedmonk
 */
public class PlayerClass implements Serializable {
    
    private String className;
    List<Map<String, String>> features;
    
    public PlayerClass(){
        
        features = new ArrayList<>();
    }
    
    public void addFeature(Map<String, String> feat){
        
        features.add(feat);
    }
    
    public void removeFeature(Map<String, String> feat){
        
        features.remove(feat);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
    
    
}
