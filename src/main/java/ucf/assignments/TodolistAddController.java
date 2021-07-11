/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class TodolistAddController {

    @FXML
    private TextField todolistaddname;


    public void addTitleButtonClicked(ActionEvent actionEvent) throws IOException {



        Parent addtolist = FXMLLoader.load(getClass().getResource("ListAdd.FXML"));
        Scene addtoScene = new Scene(addtolist);

        Stage area = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        area.setScene(addtoScene);
        area.show();
    }
}
