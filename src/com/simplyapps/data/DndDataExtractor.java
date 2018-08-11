/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.data;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author accusedmonk
 */
public class DndDataExtractor {
    
    JSONHandler jh;
    
    public DndDataExtractor(){
        
        jh = new JSONHandler();
    }
    
    public ObservableList<String> getClassList(){
        
        return FXCollections.observableArrayList(jh.getJsonMap(jh.getClassString()).keySet());
    }
    
    public ObservableList<String> getRaceList(){
        
        return FXCollections.observableArrayList(jh.getJsonMap(jh.getRaceString()).keySet());
    }
    
    public ObservableList<String> getAlignmentList(){
        
        List<String> alignList = jh.getJsonArrayData(jh.getBeyondString(), "Multiclassing", "Alignment", "content");
        
        for (int i = 0; i < alignList.size(); i++){
            
            String original = alignList.get(i);
            String sub = original.substring(original.indexOf("**")+2, original.lastIndexOf("**"));
            alignList.set(i, sub);
        }
        
        return FXCollections.observableArrayList(alignList);
    }
    
    public ObservableList<String> getClassFeatures(String className){
        
        return FXCollections.observableArrayList(jh.getJsonArrayData(className, "Class Features", "The "+className, "Features"));
    }
    
    public ObservableList<String> getBackgrounds(){
        
        ObservableList<String> backgroundList = FXCollections.observableArrayList();
        jh.getJsonEntrySetData(jh.getBeyondString(), "Backgrounds").iterator().forEachRemaining(entry -> backgroundList.add(entry.getKey()));
        
        return backgroundList;
    }
    
}
