/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class TodolistAddController {

    @FXML
    private TextField todolistaddname;
    public int number = 0;

    public void addTitleButtonClicked(ActionEvent actionEvent) {
        addToDoList atdl = new addToDoList();
        number = atdl.addtolist(number, todolistaddname.getText());
    }
}
