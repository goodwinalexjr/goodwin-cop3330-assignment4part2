package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.stage.FileChooser;
import javafx.stage.Stage;


import java.io.*;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;


import java.util.ResourceBundle;
import java.util.Scanner;


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
    //add a test so that we can see it is loading
    //somehow add a filter so that I can filter out the completed and incmpleted
    //use a boolean to know if its true
    //known information is that it will be yes and no
    //other known information is that need to only display that information

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

    //need to be able to edit the items in the list
    //use the add function as well to combine and make it easier
    //make sure that information not entered does not ruin old information with an if statement
    //set the text in the blocks to blank afterwords
    public void changeDuedateCellButtonClicked(ActionEvent actionEvent){

        toDoListList todolist = itemList.getSelectionModel().getSelectedItem();
        if(duedate.getValue().toString().isEmpty()){

        }
        else {
            todolist.setDuedate(duedate.getValue().toString());

        }

        if(title.getText().isEmpty()){

        }
        else {
            todolist.setTitle(title.getText());
            title.setText("");
        }
        if(des.getText().isEmpty()){

        }
        else {
            todolist.setDescription(des.getText());
            des.setText("");
        }
    }


    //add to the todolistlist class
    //set it up using the function up top
    //make sure to set the text blocks back to empty
    public void addbuttonClicked(ActionEvent actionEvent) throws IOException {
        toDoListList todolist = new toDoListList(title.getText(), des.getText(), "No", duedate.getValue().toString());
        tdl.addAll(todolist);
        title.setText("");
        des.setText("");
    }

    //need to get the list infoprmation
    //set the selected list
    //remove it
    public void removeButtonClicked(ActionEvent actionEvent) {
        ObservableList<toDoListList> removelist;
        removelist = itemList.getSelectionModel().getSelectedItems();

        tdl.removeAll(removelist);
    }


    //with the initialization should just need to set the information to the letter N
    public void displayincompleteButtonClicked(ActionEvent actionEvent) {
        field = "N";
        hiddensearch.setText(field);
    }
    //with the initialization should just need to set the information to the letter Y
    public void displaycompleteButtonClicked(ActionEvent actionEvent) {
        field = "Y";
        hiddensearch.setText(field);
    }
    //with the initialization should just need to set the information to null
    public void displayAllbuttonClicked(ActionEvent actionEvent) {
        field = null;
        hiddensearch.setText(field);
    }

    //need to set up the showsavedialog
    //check to see if the file is null
    //call the export function and pass in the list and file location
    public void exportlistButtonClicked(ActionEvent actionEvent) throws IOException {
        Stage save = new Stage();
        FileChooser fc = new FileChooser();
        fc.setTitle("Save");
        File file = fc.showSaveDialog(save);
        if(file != null){
            export.save(itemList.getItems(), file);
        }
    }

    //need to set up for showopendialog to get file location
    //check to see if the file location is null
    //remove all the old data
    //then need to use scanner
    //set up the extension filter
    //while there is a next line load in each string
    //then add the string to the list
    public void importlistsButtonClicked(ActionEvent actionEvent) throws IOException {

        Stage load = new Stage();
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("To do list files", "*.tdl"));
        fc.setTitle("Load");
        File file = fc.showOpenDialog(load);
        System.out.println(file.toString());
        if(file != null){

            ObservableList<toDoListList> alllist;
            alllist = itemList.getItems();
            tdl.removeAll(alllist);
            //load(itemList.getItems(), file);
            Scanner myobj = new Scanner(file);

            while(myobj.hasNextLine()){

                String title = myobj.nextLine();

                String duedate = myobj.nextLine();

                String complete = myobj.nextLine();

                String description = myobj.nextLine();

                toDoListList todolist = new toDoListList(title, description, complete, duedate);

                tdl.addAll(todolist);

            }
        }


    }


    //need to change the list items complete from yes to no or no to yes
    //do this with some if statements checking what state it is in
    //then changing it to the other state
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

    //need to get the list information
    //remove all
    public void removeAllButtonClicked(ActionEvent actionEvent) {
        ObservableList<toDoListList> alllist;
        alllist = itemList.getItems();
        tdl.removeAll(alllist);
    }

    //load new window with the help information
    //set a new scene
    //show scene
    public void HelpButtonClicked(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("help.fxml"));
        Scene scene = new Scene(parent);

        Stage stage = new Stage();
        stage.setTitle("Help");
        stage.setScene(scene);
        stage.show();
    }
}
