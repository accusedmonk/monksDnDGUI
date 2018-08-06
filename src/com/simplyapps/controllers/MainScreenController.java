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
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.input.KeyEvent;
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
    private ChoiceBox<String> savedPlayersChoiceBox, classChoiceBox, raceChoiceBox, backgroundChoiceBox, alignmentChoiceBox;
    @FXML
    private ProgressBar hitPointsProgressBar, experienceProgressBar;
    @FXML
    private ScrollPane updatesScrollPane;
    
    private Player player;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        player = new Player();
        
        startListeners();
        
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
        alertPlayer("Character "+player.characterName+" has been saved successfully.");
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
            characterNameTextField.setText(player.characterName);
            alertPlayer("Character "+player.characterName+" has been loaded successfully.");
            
        } else {
            alertPlayer("Character was not loaded.");
        }
    }
    
    @FXML
    private void updatePlayerName(KeyEvent ke){
        
        if (player != null && ke.getCode() == ke.getCode().ENTER){
            
            player.playerName = playerNameTextField.getText();
            updatePlayer("Player name changed to : "+player.playerName);
        }
    }
    
    @FXML
    private void updateCharacterName(KeyEvent ke){
        
        if (player != null && ke.getCode() == ke.getCode().ENTER){
            
            player.characterName = characterNameTextField.getText();
            updatePlayer("Character name changed to : "+player.characterName);
        }
    }
    
    private void updatePlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildUpdateText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void alertPlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildAlertText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void startListeners(){
        
        strengthSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        strengthSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setStrength(newValue);
                strengthModTextField.setText(String.valueOf(player.playerStats.getStrengthMod()));
                updatePlayer("Strength changed to : "+player.playerStats.getStrength());
            }
        });
        
        dexteritySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        dexteritySpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setDexterity(newValue);
                dexterityModTextField.setText(String.valueOf(player.playerStats.getDexterityMod()));
                updatePlayer("Dexterity changed to : "+player.playerStats.getDexterity());
            }
        });
        
        constitutionSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        constitutionSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setConstitution(newValue);
                constitutionModTextField.setText(String.valueOf(player.playerStats.getConstitutionMod()));
                updatePlayer("Constitution changed to : "+player.playerStats.getConstitution());
            }
        });
        
        intelligenceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        intelligenceSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setIntelligence(newValue);
                intelligenceModTextField.setText(String.valueOf(player.playerStats.getIntelligenceMod()));
                updatePlayer("Intelligence changed to : "+player.playerStats.getIntelligence());
            }
        });
        
        wisdomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        wisdomSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setWisdom(newValue);
                wisdomModTextField.setText(String.valueOf(player.playerStats.getWisdomMod()));
                updatePlayer("Wisdom changed to : "+player.playerStats.getWisdom());
            }
        });
        
        charismaSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        charismaSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            if (player != null){
                
                player.playerStats.setCharisma(newValue);
                //charismaModTextField.setText(String.valueOf(player.playerStats.getCharismaMod()));
                updatePlayer("Charisma changed to : "+player.playerStats.getCharisma());
            }
        });
        
        playerNameTextField.textProperty().bindBidirectional(player.playerName); 
        characterNameTextField.textProperty().bindBidirectional(player.characterName); 
        strengthModTextField.textProperty().bindBidirectional(player.playerStats.strengthMod);  
        dexterityModTextField.textProperty().bindBidirectional(player.characterName);  
        constitutionModTextField.textProperty().bindBidirectional(player.characterName); 
        intelligenceModTextField.textProperty().bindBidirectional(player.characterName);  
        wisdomModTextField, 
        charismaModTextField;
        savedPlayersChoiceBox, classChoiceBox, raceChoiceBox, backgroundChoiceBox, alignmentChoiceBox;
        hitPointsProgressBar, experienceProgressBar;
    }
    
    private void loadCharacterOptions(){
        
        JSONHandler jh = new JSONHandler();
        ObservableList<String> ol = FXCollections.observableArrayList(jh.getJsonMap("src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json").keySet());
        classChoiceBox.setItems(ol);
    }
}
