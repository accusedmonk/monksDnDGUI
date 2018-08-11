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
import java.util.Map.Entry;
import java.util.Set;
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
    
    String raceString,
    	   classString,
    	   beyondString,
    	   equipmentString,
    	   featsString,
    	   mechanicsString,
    	   combatString,
    	   spellcastingString,
    	   runningString,
    	   magicString,
    	   monstersString,
    	   conditionsString,
           godsString,
    	   planesString,
    	   creaturesString,
    	   npcsString;
    
    public JSONHandler(){
        
        gson = new Gson();
        String dir = "src\\com\\btmorton\\dnd5esrd\\json\\";
        
        raceString          = readJsonFile(new File(dir+"01 races.json"));
        classString         = readJsonFile(new File(dir+"02 classes.json"));
        beyondString        = readJsonFile(new File(dir+"03 beyond1st.json"));
        equipmentString     = readJsonFile(new File(dir+"04 equipment.json"));
        featsString         = readJsonFile(new File(dir+"05 feats.json"));
        mechanicsString     = readJsonFile(new File(dir+"06 mechanics.json"));
        combatString        = readJsonFile(new File(dir+"07 combat.json"));
        spellcastingString  = readJsonFile(new File(dir+"08 spellcasting.json"));
        runningString       = readJsonFile(new File(dir+"09 running.json"));
        magicString         = readJsonFile(new File(dir+"10 magic items.json"));
        monstersString      = readJsonFile(new File(dir+"11 monsters.json"));
        conditionsString    = readJsonFile(new File(dir+"12 conditions.json"));
        godsString          = readJsonFile(new File(dir+"13 gods.json"));
        planesString        = readJsonFile(new File(dir+"14 planes.json"));
        creaturesString     = readJsonFile(new File(dir+"15 creatures.json"));
        npcsString          = readJsonFile(new File(dir+"16 npcs.json"));
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
    
    public Map<String, Object> getJsonMap(String stringToMap){
        
        map = gson.fromJson(stringToMap, new TypeToken<Map<String, Object>>(){}.getType());
        
        return map;
    }
    
    public Set<Entry<String, JsonElement>> getJsonEntrySetData(String jsonString, String... string){
        
        JsonElement element = new JsonParser().parse(jsonString);
        JsonObject  jObject = element.getAsJsonObject();
        int stringIndex = 0;
        
        for (int i = 0; i < string.length; i++)
            jObject = jObject.getAsJsonObject(string[stringIndex++]);
        
        return jObject.entrySet();
    }
    
    public List<String> getJsonArrayData(String jsonString, String... jsonObjectNames){
        
        List<String> data = new ArrayList<>();
        JsonElement jElement = new JsonParser().parse(jsonString);
        JsonObject  jObject = jElement.getAsJsonObject();
        int stringIndex = 0;
        
        for (int i = 0; i < jsonObjectNames.length-1; i++)
            jObject = jObject.getAsJsonObject(jsonObjectNames[stringIndex++]);
        
        JsonArray jArray = jObject.getAsJsonArray(jsonObjectNames[stringIndex]);
        
        for (int i = 0; i < jArray.size(); i++)
            data.add(jArray.get(i).getAsString());
        
        return data;
    }

    public String getRaceString() {
        return raceString;
    }

    public String getClassString() {
        return classString;
    }

    public String getBeyondString() {
        return beyondString;
    }

    public String getEquipmentString() {
        return equipmentString;
    }

    public String getFeatsString() {
        return featsString;
    }

    public String getMechanicsString() {
        return mechanicsString;
    }

    public String getCombatString() {
        return combatString;
    }

    public String getSpellcastingString() {
        return spellcastingString;
    }

    public String getRunningString() {
        return runningString;
    }

    public String getMagicString() {
        return magicString;
    }

    public String getMonstersString() {
        return monstersString;
    }

    public String getConditionsString() {
        return conditionsString;
    }

    public String getPlanesString() {
        return planesString;
    }

    public String getCreaturesString() {
        return creaturesString;
    }

    public String getNpcsString() {
        return npcsString;
    }
    
    
}
