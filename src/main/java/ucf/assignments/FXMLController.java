/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class FXMLController {

    ObservableList<toDoList> info = FXCollections.observableArrayList();

    @FXML
    private ListView todolistlist;
    @FXML
    private TextField Title;


    int number = 0;

    /*public void initialize(){
        todolistlist.getItems().addAll("test");

    }*/


    public void newButtonClickedTDL(ActionEvent actionEvent) throws IOException {
        if(Title.getText().isBlank()){

        }
        else {
            todolistlist.getItems().addAll(Title.getText());
            
            Title.setText("");
        }
    }

    public void edidButtonClickedTDL(ActionEvent actionEvent) {
        //will call the todolistaddcontroller and the edittodolist class
    }

    public void deleteButtonClickedTDL(ActionEvent actionEvent) {
        //call the removetodolist class and remove function
    }


    public void GotoListButton(ActionEvent actionEvent) {

        int Itemint = todolistlist.getSelectionModel().getSelectedIndex();


        System.out.println(Itemint);
    }
}

class toDoList {

    public final SimpleStringProperty tdl;

    public toDoList (String tdl){
        this.tdl = new SimpleStringProperty(tdl);
    }

        public String getTdl(){

            return tdl.get();

        }

}
