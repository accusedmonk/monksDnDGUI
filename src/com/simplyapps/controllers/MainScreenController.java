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
import java.io.Serializable;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
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
public class MainScreenController implements Serializable, Initializable {
    
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
        
        if (savedPlayerList.size() > 0)
            savedPlayersChoiceBox.setItems(savedPlayerList);
        
        String playerName = "";
        
        if (savedPlayersChoiceBox.getItems().size() > 0)
            playerName = savedPlayersChoiceBox.getValue();
        
        if (playerName != null && playerName.length() > 0){
            player = PlayerSaveIO.load(playerName);
            characterNameTextField.setText(player.characterName);
            alertPlayer("Character "+player.characterName+" has been loaded successfully.");
        } else {
            alertPlayer("Character was not loaded.");
        }
    }
    
    @FXML
    private void updateCharacterName(){
        
        player.characterName = characterNameTextField.getText();
    }
    
    private void updatePlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildUpdateText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void alertPlayer(String message){
        
        textUpdatesTextFlow.getChildren().add(UpdateTextBuilder.buildAlertText(message));
        updatesScrollPane.setVvalue(updatesScrollPane.getVmax());
    }
    
    private void startSpinnerListeners(){
        
        intelligenceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        intelligenceSpinner.valueProperty().addListener((ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) -> {
            
            player.playerStats.setIntelligence(newValue);
            intelligenceModTextField.setText(String.valueOf(player.playerStats.getIntelligenceMod()));
            updatePlayer("Intelligence changed to : "+player.playerStats.getIntelligence());
        });
    }
    
    private void loadCharacterOptions(){
        
        JSONHandler jh = new JSONHandler();
        ObservableList<String> ol = FXCollections.observableArrayList(jh.getJsonMap("src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json").keySet());
        classChoiceBox.setItems(ol);
    }
    
    private void promptComboBox(){
        
        
    }
}
