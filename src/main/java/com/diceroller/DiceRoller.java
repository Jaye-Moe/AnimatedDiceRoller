package com.diceroller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiceRoller extends Application {
    @Override
    public void start(Stage stage) {
        UI ui = new UI();
        ui.generateDice();
        ui.generateRollAllButton();
        ui.addInstructions();

        Scene scene = new Scene(ui.getGridPane());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}