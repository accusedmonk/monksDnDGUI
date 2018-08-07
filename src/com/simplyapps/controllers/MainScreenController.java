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
import javafx.beans.binding.Bindings;
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
import javafx.util.converter.NumberStringConverter;

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
        alertPlayer("Character "+player.characterName.getValue()+" has been saved successfully.");
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
            characterNameTextField.setText(player.characterName.getValue());
            alertPlayer("Character "+player.characterName.getValue()+" has been loaded successfully.");
            
        } else {
            alertPlayer("Character was not loaded.");
        }
    }
    
    @FXML
    private void updatePlayerName(KeyEvent ke){
        
        if (player != null && ke.getCode() == ke.getCode().ENTER){
            
            player.playerName.setValue(playerNameTextField.getText());
            updatePlayer("Player name changed to : "+player.playerName);
        }
    }
    
    @FXML
    private void updateCharacterName(KeyEvent ke){
        
        if (player != null && ke.getCode() == ke.getCode().ENTER){
            
            player.characterName.setValue(characterNameTextField.getText());
            updatePlayer("Character name changed to : "+player.characterName.getValue());
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
        dexteritySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        constitutionSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        intelligenceSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        wisdomSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        charismaSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 30, 0));
        
        playerNameTextField.textProperty().bindBidirectional(player.playerName); 
        characterNameTextField.textProperty().bindBidirectional(player.characterName);
        
        strengthSpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.strength.asObject());
        dexteritySpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.dexterity.asObject());
        constitutionSpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.constitution.asObject());
        intelligenceSpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.intelligence.asObject());
        wisdomSpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.wisdom.asObject());
        charismaSpinner.getValueFactory().valueProperty().bindBidirectional(player.playerStats.charisma.asObject());
        
        Bindings.bindBidirectional(strengthModTextField.textProperty(), player.playerStats.strengthMod, new NumberStringConverter());
        Bindings.bindBidirectional(dexterityModTextField.textProperty(), player.playerStats.dexterityMod, new NumberStringConverter());
        Bindings.bindBidirectional(constitutionModTextField.textProperty(), player.playerStats.strengthMod, new NumberStringConverter());
        Bindings.bindBidirectional(intelligenceModTextField.textProperty(), player.playerStats.strengthMod, new NumberStringConverter());
        Bindings.bindBidirectional(wisdomModTextField.textProperty(), player.playerStats.strengthMod, new NumberStringConverter());
        Bindings.bindBidirectional(charismaModTextField.textProperty(), player.playerStats.strengthMod, new NumberStringConverter());
        
        hitPointsProgressBar.progressProperty().bindBidirectional(player.playerStats.currentHitPoints);
        experienceProgressBar.progressProperty().bindBidirectional(player.playerStats.experience);
    }
    
    private void loadCharacterOptions(){
        
        JSONHandler jh = new JSONHandler();
        ObservableList<String> ol = FXCollections.observableArrayList(jh.getJsonMap("src\\com\\btmorton\\dnd5esrd\\json\\02 classes.json").keySet());
        classChoiceBox.setItems(ol);
    }
}
