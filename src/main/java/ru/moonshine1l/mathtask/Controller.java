package ru.moonshine1l.mathtask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.util.Random;

public class Controller {

    @FXML
    private ChoiceBox<Integer> classSelection;

    @FXML
    private Button generate;

    @FXML
    private Label task;

    @FXML
    void initialize(){
        classSelection.getItems().setAll(
                1,
                2,
                3,
                4);

        Integer valueClass = classSelection.getValue();


        generate.setOnAction( new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                
                switch (classSelection.getValue()) {
                    case (1):
                        task.setText(firstTask(0,50));
                        break;
                    case (2):
                        task.setText(firstTask(0,100));
                        break;
                    case(3):
                        task.setText(secondTask(0, 500));
                        break;
                    case(4):
                        task.setText(secondTask(0,1000));
                        break;
                }
            }});


    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String firstTask(int min, int max){
        String [] operator = {"+", "-"};
        Random random = new Random();
        int select = random.nextInt(operator.length);
        return getRandomNumber(min,max) + operator[select] + (getRandomNumber(min,max)) + "=";
    }

    public String secondTask(int min, int max){
        String [] operator = {"+", "-", "*", ":"};
        Random random = new Random();
        int select = random.nextInt(operator.length);
        return getRandomNumber(min,max) + operator[select] + (getRandomNumber(min, max)) + "=";
    }
}

