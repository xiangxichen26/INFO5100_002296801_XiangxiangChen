package org.example.exercise3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

/**
 * A simple calculator application built using JavaFX.
 * This class sets up the GUI for a calculator and handles basic arithmetic operations including addition, subtraction,
 * multiplication, and division. It also provides buttons for clearing the calculation or completing the calculation.
 */
public class Main extends Application {
    private String number1 = ""; // Holds the first number in the calculation
    private String number2 = ""; // Holds the second number in the calculation
    private String operation = ""; // Holds the operation to be performed between the numbers
    private static boolean flag = false; // Used to reset number1 when a new operation begins

    /**
     * Starts the application and sets up the user interface.
     * The UI includes a text field for displaying numbers and operations, and a grid of buttons for input.
     *
     * @param primaryStage The primary stage for this application, onto which the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        TextField textField = new TextField("");
        textField.setFont(new Font(40));
        pane.setTop(textField);

        GridPane pane2 = new GridPane();
        pane2.setAlignment(Pos.CENTER);
        pane2.setHgap(5);
        pane2.setVgap(5);
        String[] buttonName = { "7", "8", "9", "AC", "4", "5", "6", "/", "1", "2", "3", "*", "0", "+", "-", "=" };
        Button[] b = new Button[buttonName.length];
        int col = 0, row = 0;
        for (int i = 0; i < buttonName.length; i++) {
            b[i] = new Button(buttonName[i]);
            pane2.add(b[i], col++, row);
            b[i].setOnAction(e -> {
                String s = ((Button)(e.getSource())).getText();
                switch (s)
                {
                    case "*" :
                    case "/" :
                    case "+" :
                    case "-" :
                        if(number1.isEmpty())
                        {
                            if(s.equals("*") || s.equals("/")) textField.setText("Invalid operation!");
                            else
                            {
                                number1 += s;
                                textField.setText(number1);
                            }
                        }
                        else
                        {
                            flag = false;
                            operation = s;
                            textField.setText(number1 + s);
                            number2 = "";
                        }
                        break;
                    case "AC" :
                        number1 = "";
                        number2 = "";
                        operation = "";
                        textField.setText("");
                        break;
                    case "=" :
                        if(!number1.isEmpty() && operation.isEmpty() && number2.isEmpty())
                        {
                            number1 = String.valueOf(Double.parseDouble(number1));
                            textField.setText(number1);
                            break;
                        }
                        if(!number1.isEmpty() && !operation.isEmpty() && !number2.isEmpty())
                        {
                            double count = 0;
                            boolean flag = true;
                            switch (operation)
                            {
                                case "+":
                                    count = Double.parseDouble(number1) + Double.parseDouble(number2);
                                    break;
                                case "-":
                                    count = Double.parseDouble(number1) - Double.parseDouble(number2);
                                    break;
                                case "*":
                                    count = Double.parseDouble(number1) * Double.parseDouble(number2);
                                    break;
                                case "/":
                                    if(Integer.parseInt(number2) == 0) flag = false;
                                    else count = Double.parseDouble(number1) / Double.parseDouble(number2);
                                    break;
                            }
                            if(flag)
                            {
                                number1 = String.valueOf(count);
                                operation = "";
                                number2 = "";
                                textField.setText(number1);
                            }
                            else
                            {
                                number1 = "";
                                operation = "";
                                number2 = "";
                                textField.setText("ERROR!!!");
                            }
                        }
                        else
                        {
                            number1 = "";
                            operation = "";
                            number2 = "";
                            textField.setText("ERROR!!!");
                        }
                        break;
                    default:
                        if(flag)
                        {
                            number1 = "";
                            flag = false;
                        }
                        if(operation.isEmpty())
                        {
                            number1 += s;
                            textField.setText(number1);
                        }
                        else
                        {
                            number2 += s;
                            textField.setText(number1 + operation + number2);
                        }
                }
            });
            if (col > 3) {
                col = 0;
                row++;
            }
            b[i].setStyle("-fx-font-size: 35px;-fx-pref-width:100px;-fx-pref-height:100px;");
        }
        pane.setCenter(pane2);

        Scene scene = new Scene(pane,450,520);
        primaryStage.setTitle("Xinagxiang's Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
