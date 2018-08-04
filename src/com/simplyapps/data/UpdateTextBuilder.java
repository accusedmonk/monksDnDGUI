/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.data;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author accusedmonk
 */
public class UpdateTextBuilder {
    
    public static Text buildUpdateText(String update){
        
        Text updateText = new Text();
        updateText.setText(update+"\n");
        updateText.setFill(Color.GREEN);
        updateText.setFont(Font.font(16));
        
        return updateText;
    }
    
    public static Text buildAlertText(String update){
        
        Text alertText = new Text();
        alertText.setText(update+"\n");
        alertText.setFill(Color.RED);
        alertText.setFont(Font.font(16));
        
        return alertText;
    }
    
}
