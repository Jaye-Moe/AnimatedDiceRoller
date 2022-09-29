package com.diceroller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;

public class UI {
    private final ArrayList<Dice> dice;
    private final Button rollDice;
    private final GridPane gridPane;
    private final Text instructions;

    public UI(){
        this.dice = new ArrayList<>();
        this.rollDice = new Button();
        this.gridPane = new GridPane();
        this.gridPane.setMinSize(550,300);
        this.gridPane.setPadding(new Insets(10, 10, 10, 10));
        this.gridPane.setVgap(5);
        this.gridPane.setHgap(5);
        this.instructions = new Text();
    }

    public void generateDice(){
        int i = 1;
        while (i<=5){
            Dice die = new Dice();
            this.dice.add(die);
            this.gridPane.add(die.getDice(),i,1);
            i = i + 1;
        }
    }

    public void generateRollAllButton(){
        this.rollDice.setText("Roll All Dice");
        this.gridPane.add(this.rollDice,3,2);
        this.rollDice.setOnMouseClicked(e -> this.rollAllDice());
    }

    public void rollAllDice(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.05), event -> {
            for (Dice die: this.dice){
                die.rollDice();
            }
        }));
        timeline.setCycleCount(25);
        timeline.play();
    }

    public void addInstructions(){
        this.instructions.setText("Click a die to roll it, or click the button to roll all the dice.");
        this.gridPane.add(this.instructions,1,3,5,1);
    }

    public GridPane getGridPane(){
        return this.gridPane;
    }
}
