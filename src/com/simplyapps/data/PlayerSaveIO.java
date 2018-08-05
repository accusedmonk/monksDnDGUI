/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.data;

import com.simplyapps.entities.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author accusedmonk
 */
public class PlayerSaveIO {

    private static File playersDir = new File("./players/");
            
    public static void save(Player player) {

        try {
            
            if (!playersDir.exists())
                playersDir.mkdir();
            
            FileOutputStream fileOut = new FileOutputStream(playersDir.getPath()+"\\"+player.characterName+".ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(player);
            out.close();
            fileOut.close();

        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static Player load(String characterName) {
        
        Player player = null;
        
        try {
            FileInputStream fileIn = new FileInputStream(playersDir.getPath()+"\\"+characterName+".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            player = (Player) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        
        return player;
    }
    
    public static List<String> getPlayerSaveList(){
        
        List<String> playerNames = new ArrayList<>();
        
        File[] playerFiles = playersDir.listFiles();
        
        if (playerFiles != null && playerFiles.length > 0)
            Arrays.stream(playerFiles).forEach(playerFile -> playerNames.add(playerFile.getName()));
        
        return playerNames; 
    }
}
