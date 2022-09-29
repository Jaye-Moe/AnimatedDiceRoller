package com.diceroller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;

public class Dice {
    private final Image side1;
    private final Image side2;
    private final Image side3;
    private final Image side4;
    private final Image side5;
    private final Image side6;
    private final ImageView image;

    public Dice(){
        this.side1 = new Image("file:dice1.png");
        this.side2 = new Image("file:dice2.png");
        this.side3 = new Image("file:dice3.png");
        this.side4 = new Image("file:dice4.png");
        this.side5 = new Image("file:dice5.png");
        this.side6 = new Image("file:dice6.png");
        this.image = new ImageView(this.side1);
        this.image.setOnMouseClicked(e-> clickedDice());
    }

    public void clickedDice(){
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(.05), event -> rollDice()));
        timeline.setCycleCount(25);
        timeline.play();
    }

    public void rollDice(){
        Random roll = new Random();
        int newSide = roll.nextInt(6);
        newSide++;
        this.changeSide(newSide);
    }

    public void changeSide(int newSide){
        if (newSide==1){
            this.image.setImage(this.side1);
        }
        if (newSide==2){
            this.image.setImage(this.side2);
        }
        if (newSide==3){
            this.image.setImage(this.side3);
        }
        if (newSide==4){
            this.image.setImage(this.side4);
        }
        if (newSide==5){
            this.image.setImage(this.side5);
        }
        if (newSide==6){
            this.image.setImage(this.side6);
        }
    }

    public ImageView getDice(){
        return this.image;
    }
}
