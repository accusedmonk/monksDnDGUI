/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.controllers;

import com.simplyapps.data.JSONHandler;
import com.simplyapps.data.UpdateTextBuilder;
import com.simplyapps.entities.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 *
 * @author accusedmonk
 */
public class MainScreenController implements Initializable {
    
    @FXML
    private TextFlow textUpdatesTextFlow;
    @FXML
    private TextField playerNameTextField, characterNameTextField, 
                        strengthModTextField, dexterityModTextField, constitutionModTextField,
                        intelligenceModTextField, wisdomModTextField, charismaModTextField;
    @FXML
    private Spinner<Integer> strengthSpinner, dexteritySpinner, constitutionSpinner, intelligenceSpinner, wisdomSpinner, charismaSpinner;
    @FXML
    private ChoiceBox classChoiceBox, raceChoiceBox, backgroundChoiceBox, alignmentChoiceBox;
    @FXML
    private ProgressBar hitPointsProgressBar, experienceProgressBar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Player p = new Player();
        
        intelligenceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        intelligenceSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, //
                Integer oldValue, Integer newValue) -> {
            p.playerStats.setIntelligence(newValue);
            intelligenceModTextField.setText(String.valueOf(p.playerStats.getIntelligenceMod()));
        });
        
        
        for (int i = 0; i < 10; i++){
            textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildUpdateText("Testing update builder "+i));
            textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildAlertText("Testing alert builder "+i));
        }
        JSONHandler jh = new JSONHandler("C:\\NetBeans Apps\\DnDPlayerInterface\\src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json");
    }    
    
    
    @FXML
    private void exitOnButton(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void saveCharacter(){
        
        
    }
    
}
