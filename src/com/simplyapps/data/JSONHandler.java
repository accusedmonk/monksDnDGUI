/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.data;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
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
    
    public List<String> getJsonClassData(String className, String dataName){
        
        String jsonString = readJsonFile(new File("src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json"));
        
        JsonElement jelement = new JsonParser().parse(jsonString);
        JsonObject  pClass = jelement.getAsJsonObject();
        pClass = pClass.getAsJsonObject(className);
        pClass = pClass.getAsJsonObject("Class Features");
        pClass = pClass.getAsJsonObject("The "+className);
        pClass = pClass.getAsJsonObject("table");
        JsonArray jarray = pClass.getAsJsonArray(dataName);
        
        List<String> features = new ArrayList<>();
        
        for (int i = 0; i < jarray.size(); i++)
            features.add(jarray.get(i).getAsString());
        
        return features;
    }
}
