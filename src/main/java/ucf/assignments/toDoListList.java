/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

import java.time.LocalDate;

public class toDoListList {
    //title string for the item
    //due date for the item
    //boolean for complete or not
    //description for the item being insertedd

    //functions that can add those items to the class
    //make sure that it is an array that can hold all the information like toDoListlist[] tdll = new toDoListList[100]

    private SimpleStringProperty title;
    private SimpleStringProperty description;
    private SimpleStringProperty complete;
    private SimpleStringProperty duedate;

    public toDoListList(String title, String description, String complete, String duedate) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.complete = new SimpleStringProperty(complete);
        this.duedate = new SimpleStringProperty(duedate);;
    }

    public String getComplete() {
        return complete.get();
    }

    public SimpleStringProperty completeProperty() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete.set(complete);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getDescription() {
        return description.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getDuedate() {
        return duedate.get();
    }

    public SimpleStringProperty duedateProperty() {
        return duedate;
    }

    public void setDuedate(String duedate) {
        this.duedate.set(duedate);
    }
}
