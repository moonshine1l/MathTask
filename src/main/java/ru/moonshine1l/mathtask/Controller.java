package ru.moonshine1l.mathtask;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Random;

public class Controller {

    @FXML
    private ChoiceBox<Integer> classSelection;

    @FXML
    private Button generate;

    @FXML
    private Label task;

    @FXML
    private Label message;

    @FXML
    private TextField answer;

    @FXML
    private Button checkAnswer;

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
                        task.setText(String.valueOf(firstTask(0,100)));
                        break;
                    case(3):
                        task.setText(secondTask(0, 250, 1, 10));
                        break;
                    case(4):
                        task.setText(secondTask(0,500,1,10));
                        break;

                }

            }});

        checkAnswer.setOnAction((ActionEvent event) -> {
                if(Integer.parseInt(task.getText()) == Integer.parseInt(answer.getText())){
                    message.setText("Верно!)");
                }else {
                    message.setText("Ты ошибся(");
                }
        });

    }
    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public String firstTask(int min, int max){
        String [] operator = {"+", "-"};
        Random random = new Random();
        int select = random.nextInt(operator.length);
        int taskoper = 0;
        return getRandomNumber(min,max) + operator[select] +  getRandomNumber(min,max);

        if(operator[select].equals("+")){
            taskoper = getRandomNumber(min,max) + getRandomNumber(min,max);
        }else if(operator[select].equals("-")) {
            taskoper = getRandomNumber(min, max)  -  (getRandomNumber(min, max));
        }
        return String.valueOf(taskoper);
    }

    public String secondTask(int min, int max, int smin, int smax){
         String[] operator = {"+", "-", "*", ":"};
        Random random = new Random();
        int select = random.nextInt(operator.length);

        return getRandomNumber(min,max) + operator[select] + (getRandomNumber(smin, smax)) + "=";
    }

//    public int checkFirstResult(){
//        String [] operator = {"+", "-"};
//        Random random = new Random();
//        int select = random.nextInt(operator.length);
//        int taskoper = 0;
//        String result = getRandomNumber() + operator[select] +  getRandomNumber();
//
//        if(operator[select].equals("+")){
//            taskoper = getRandomNumber() + getRandomNumber();
//        }else if(operator[select].equals("-")) {
//            taskoper = getRandomNumber()  -  (getRandomNumber());
//        }
//        return taskoper;
//    }
}


