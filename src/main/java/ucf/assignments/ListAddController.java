package ucf.assignments;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
    private TableColumn<toDoListList, Boolean> finished;
    @FXML
    private CheckBox finsihedcheck;
    @FXML
    private TableColumn<toDoListList, LocalDate> dueDate;



    public void initialize(URL location, ResourceBundle resources){
        item.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("title"));
        description.setCellValueFactory(new PropertyValueFactory<toDoListList, String>("description"));
        dueDate.setCellValueFactory(new PropertyValueFactory<toDoListList, LocalDate>("duedate"));
        finished.setCellValueFactory(new PropertyValueFactory<toDoListList, Boolean>("complete"));


        itemList.setItems(getList());

    }

    private ObservableList<toDoListList> getList() {
        ObservableList<toDoListList> tdl = FXCollections.observableArrayList();
        tdl.add(new toDoListList("Test", "Description", false, LocalDate.of(2021, Month.JULY, 15)));

        return tdl;
    }


    public void addbuttonClicked(ActionEvent actionEvent) throws IOException {
        Parent addtolist = FXMLLoader.load(getClass().getResource("TodolistAdd.FXML"));
        Scene addtoScene = new Scene(addtolist);

        Stage area = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();

        area.setScene(addtoScene);
        area.show();
    }

    public void removeButtonClicked(ActionEvent actionEvent) {
    }

    public void editlistButtonClicked(ActionEvent actionEvent) {
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

    public void checkboxClicked(ActionEvent actionEvent) {
    }

    public void CompleteButtonClicked(ActionEvent actionEvent) {
    }
}
