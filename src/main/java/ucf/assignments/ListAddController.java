package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;


import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;

import java.util.ResourceBundle;

public class ListAddController implements Initializable {

    @FXML
    private TableView<toDoListList> itemList;
    @FXML
    private TableColumn<toDoListList, String> item;
    @FXML
    private TableColumn<toDoListList, String> description;
    @FXML
    private TableColumn<toDoListList, String> finished;
    @FXML
    private TableColumn<toDoListList, LocalDate> dueDate;
    @FXML
    private TextField title;
    @FXML
    private DatePicker duedate;
    @FXML
    private TextArea des;



    public void initialize(URL location, ResourceBundle resources){
        item.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<toDoListList, LocalDate>("duedate"));
        finished.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("complete"));


        itemList.setItems(getList());
        itemList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        itemList.setEditable(true);
        item.setCellFactory(TextFieldTableCell.forTableColumn());
        item.setEditable(true);
        description.setEditable(true);
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        dueDate.setEditable(true);



    }

    public void changeTitleCellEvent(TableColumn.CellEditEvent edditedCell){

        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        todolist.setTitle(edditedCell.getNewValue().toString());
    }

    public void changeDescritionCellEvent(TableColumn.CellEditEvent edditedCell){

        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        todolist.setDescription(edditedCell.getNewValue().toString());
    }

    public void changeDuedateCellButtonClicked(ActionEvent actionEvent){

        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        todolist.setDuedate(duedate.getValue());
        todolist.setTitle(title.getText());
        todolist.setDescription(des.getText());
    }

    private ObservableList<toDoListList> getList() {
        ObservableList<toDoListList> tdl = FXCollections.observableArrayList();
        tdl.add(new toDoListList("Test", "Description", "No", LocalDate.of(2021, Month.JULY, 15)));

        return tdl;
    }



    public void addbuttonClicked(ActionEvent actionEvent) throws IOException {
        toDoListList todolist = new toDoListList(title.getText(), des.getText(), "No", duedate.getValue());
        itemList.getItems().add(todolist);
    }

    public void removeButtonClicked(ActionEvent actionEvent) {
        ObservableList<toDoListList> removelist, alllist;
        alllist = itemList.getItems();
        removelist = itemList.getSelectionModel().getSelectedItems();

        for(toDoListList todolist : removelist){
            alllist.remove(todolist);
        }


    }



    public void displayincompleteButtonClicked(ActionEvent actionEvent) {
    }

    public void displaycompleteButtonClicked(ActionEvent actionEvent) {
    }

    public void displayAllbuttonClicked(ActionEvent actionEvent) {
    }

    public void exportlistButtonClicked(ActionEvent actionEvent) {
    }

    public void importlistsButtonClicked(ActionEvent actionEvent) {
    }


    public void CompleteButtonClicked(ActionEvent actionEvent) {
        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        if(todolist.getComplete().equals("Yes")){
            todolist.setComplete("No");
            itemList.getItems();
        }
        else {
            todolist.setComplete("Yes");
            itemList.getItems();
        }
    }

    public void removeAllButtonClicked(ActionEvent actionEvent) {
        itemList.getItems().clear();
    }
}
