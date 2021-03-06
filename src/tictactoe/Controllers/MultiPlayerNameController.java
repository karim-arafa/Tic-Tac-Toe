/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.Controllers;

import helpers.AnimationHelper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import tictactoe.Scenes.MainMenuBase;
import tictactoe.Scenes.MultiplayerGameBase;

/**
 *
 * @author OMAR YEHIA
 */
public class MultiPlayerNameController {
    
    private String name;
    private MainMenuBase mainMenu;
    private MultiplayerGameBase multiGame;
    private MediaPlayer clickSound;
    

    public MultiPlayerNameController(
            Stage primaryStage,
            Button backBtn,
            Button confirmBtn,
            TextField playerName) {
       
        
        clickSound = new MediaPlayer(
                new Media(getClass().getResource("/sounds/click-sound.mp3").toExternalForm()));
        
        backBtn.setOnAction(e -> {
            mainMenu = new MainMenuBase(primaryStage);
            Scene scene = new Scene(mainMenu, 636, 596);
            AnimationHelper.fadeAnimate(mainMenu);
            clickSound.play();
            primaryStage.setScene(scene);
        });
        
        confirmBtn.setOnAction(e -> {
                name = playerName.getText();
                multiGame = new MultiplayerGameBase(primaryStage, name);
                Scene scene = new Scene(multiGame, 636, 596);
                AnimationHelper.fadeAnimate(multiGame);
                clickSound.play();
                primaryStage.setScene(scene);
        });
        
    }
    
    
    
}
