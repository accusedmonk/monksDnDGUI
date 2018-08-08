/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyapps.controllers;

import com.simplyapps.data.JSONHandler;
import com.simplyapps.data.PlayerSaveIO;
import com.simplyapps.data.UpdateTextBuilder;
import com.simplyapps.entities.Player;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
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
    private ChoiceBox<String> classChoiceBox, raceChoiceBox, backgroundChoiceBox, alignmentChoiceBox;
    @FXML
    private ProgressBar hitPointsProgressBar, experienceProgressBar;
    @FXML
    private ScrollPane updatesScrollPane;
    
    private Player player;
    private Map<String, Spinner> spinnerMap;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        player = new Player();
        spinnerMap = new TreeMap<>();
        
        mapControls();
        startSpinnerListeners();
        loadCharacterOptions();
    }    
    
    
    @FXML
    private void exitOnButton(ActionEvent event) {
        
        Platform.exit();
        System.exit(0);
    }
    
    @FXML
    private void saveCharacter(){
        
        PlayerSaveIO.save(player);
    }
    
    @FXML
    private void loadCharacter(){
        
        ObservableList<String> savedPlayerList = FXCollections.observableArrayList(PlayerSaveIO.getPlayerSaveList());
        
        ChoiceDialog<String> choices = new ChoiceDialog<>(savedPlayerList.iterator().next());
        
        choices.setTitle("Load Character");
        choices.setContentText("Please select a character to load.");
        choices.showAndWait();
        
        String playerName = choices.getResult();
        
        if (playerName != null && playerName.length() > 0){
            
            player = PlayerSaveIO.load(playerName);
            alertPlayer("Character "+player.characterName+" has been loaded successfully.");
            
        } else {
            alertPlayer("Character was not loaded.");
        }
    }
    
    @FXML
    private void updateCharacterName(){
        
        player.characterName = characterNameTextField.getText();
    }
    
    @FXML
    private void updatePlayerName(){
        
        player.playerName = playerNameTextField.getText();
    }
    
    private void updatePlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildUpdateText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void alertPlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildAlertText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void mapControls(){
        
        spinnerMap.put("Strength", strengthSpinner);
        spinnerMap.put("Dexterity", dexteritySpinner);
        spinnerMap.put("Constitution", constitutionSpinner);
        spinnerMap.put("Intelligence", intelligenceSpinner);
        spinnerMap.put("Wisdom", wisdomSpinner);
        spinnerMap.put("Charisma",charismaSpinner);
    }
    
    private void startSpinnerListeners(){
        
        spinnerMap.entrySet().forEach(entry -> {
        
            entry.getValue().setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
            entry.getValue().valueProperty().addListener((observable, oldValue, newValue) -> {
            
                updatePlayerStats(entry.getKey(), (int)newValue);
                updatePlayer(entry.getKey()+" changed to : "+(int)newValue);
            });
        });
        
    }
    
    private void updatePlayerStats(String stat, int newValue){
        
        if (stat.matches("Strength")){
            player.playerStats.setStrength(newValue);
            strengthModTextField.setText(String.valueOf(player.playerStats.getStrengthMod()));
        } 
        else if (stat.matches("Dexterity")){
            player.playerStats.setDexterity(newValue);
            dexterityModTextField.setText(String.valueOf(player.playerStats.getDexterityMod()));
        }
        else if (stat.matches("Constitution")){
            player.playerStats.setConstitution(newValue);
            constitutionModTextField.setText(String.valueOf(player.playerStats.getConstitutionMod()));
        }
        else if (stat.matches("Intelligence")){
            player.playerStats.setIntelligence(newValue);
            intelligenceModTextField.setText(String.valueOf(player.playerStats.getIntelligenceMod()));
        }
        else if (stat.matches("Wisdom")){
            player.playerStats.setWisdom(newValue);
            wisdomModTextField.setText(String.valueOf(player.playerStats.getWisdomMod()));
        }
        else if (stat.matches("Charisma")){
            player.playerStats.setCharisma(newValue);
            charismaModTextField.setText(String.valueOf(player.playerStats.getCharismaMod()));
        }
    }
    
    private void loadCharacterOptions(){
        
        JSONHandler jh = new JSONHandler();
        ObservableList<String> ol = FXCollections.observableArrayList(jh.getJsonMap("src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json").keySet());
        classChoiceBox.setItems(ol);
    }
}
