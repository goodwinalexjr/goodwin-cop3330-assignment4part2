package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Filter;

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
    @FXML
    private  TextField hiddensearch;

    private  String field = null;
    public final ObservableList<toDoListList> tdl = FXCollections.observableArrayList();



    //initialize the code to display the tables
    //make sure that the tables are editable in the program

    public void initialize(URL location, ResourceBundle resources){
        item.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<toDoListList, LocalDate>("duedate"));
        finished.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("complete"));


        toDoListList tdl1 = new toDoListList("Test", "Description", "No", LocalDate.of(2021, Month.JULY, 15).toString());
        tdl.addAll(tdl1);

        FilteredList<toDoListList> filter = new FilteredList<>(tdl, b -> true);

        hiddensearch.setText(field);
        hiddensearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filter.setPredicate(todolist -> {

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }

                String lcf = newValue.toLowerCase();

                if(todolist.getComplete().toLowerCase().indexOf(lcf) != -1) {
                    return true;
                }
                else {
                    return false;
                }
            });
        });


        SortedList<toDoListList> sort = new SortedList<>(filter);
        sort.comparatorProperty().bind(itemList.comparatorProperty());
        itemList.setItems(sort);

        itemList.setEditable(true);
        item.setEditable(true);
        description.setEditable(true);
        dueDate.setEditable(true);



    }


    public void changeDuedateCellButtonClicked(ActionEvent actionEvent){

        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        todolist.setDuedate(duedate.getValue().toString());
        todolist.setTitle(title.getText());
        todolist.setDescription(des.getText());
        System.out.println(duedate.getValue().toString());
    }


    public void addbuttonClicked(ActionEvent actionEvent) throws IOException {
        toDoListList todolist = new toDoListList(title.getText(), des.getText(), "No", duedate.getValue().toString());
        tdl.addAll(todolist);
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
        field = "N";
        hiddensearch.setText(field);
    }

    public void displaycompleteButtonClicked(ActionEvent actionEvent) {
        field = "Y";
        hiddensearch.setText(field);
    }

    public void displayAllbuttonClicked(ActionEvent actionEvent) {
        field = null;
        hiddensearch.setText(field);
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
