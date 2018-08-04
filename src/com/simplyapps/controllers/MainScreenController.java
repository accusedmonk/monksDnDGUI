/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.controllers;

import com.simplyapps.data.JSONHandler;
import com.simplyapps.entities.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 *
 * @author accusedmonk
 */
public class MainScreenController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField intelligenceModTextField;
    @FXML
    private Spinner<Integer> intelligenceSpinner;
    
    @FXML
    private void exitOnButton(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Player p = new Player();
        
        intelligenceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        intelligenceSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, //
                Integer oldValue, Integer newValue) -> {
            p.playerStats.setIntelligence(newValue);
            intelligenceModTextField.setText(String.valueOf(p.playerStats.getIntelligenceMod()));
        });
        
        JSONHandler jh = new JSONHandler("C:\\NetBeans Apps\\DnDPlayerInterface\\src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json");
    }    
    
}
