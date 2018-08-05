/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.data;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author accusedmonk
 */
public class JSONHandler {
    
    JsonObject jsonObject;
    Map<String, Object> map;
    Gson gson;
    File json;
    
    public JSONHandler(){
        
        gson = new Gson();
    }
    
    private String readJsonFile(File file){
        StringBuilder jsonString = new StringBuilder();
        
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            
            fileReader.lines().forEach(string -> jsonString.append(string));
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JSONHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return jsonString.toString();
    }
    
    public Map<String, Object> getJsonMap(String filePath){
        
        json = new File(filePath);
        map = gson.fromJson(readJsonFile(json), new TypeToken<Map<String, Object>>(){}.getType());
        
        return map;
    }
}
