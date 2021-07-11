/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;



public class App extends Application{

    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("UI1.fxml"));

        Scene scene = new Scene(root);




        stage.setTitle("To-do list");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){


        launch(args);
    }
}


