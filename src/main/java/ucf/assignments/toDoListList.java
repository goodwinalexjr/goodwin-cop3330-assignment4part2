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
    private boolean complete;
    private LocalDate duedate;

    public toDoListList(String title, String description, boolean complete, LocalDate duedate) {
        this.title = new SimpleStringProperty(title);
        this.description = new SimpleStringProperty(description);
        this.complete = complete;
        this.duedate = duedate;
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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public LocalDate getDuedate() {
        return duedate;
    }

    public void setDuedate(LocalDate duedate) {
        this.duedate = duedate;
    }
}
