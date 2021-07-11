/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.beans.property.SimpleStringProperty;

public class toDoList2 {

    public final SimpleStringProperty tdl;

    public toDoList2 (String TDL){
       this.tdl = new SimpleStringProperty(TDL);
    }

    public String getTitle(){

        return tdl.get();

    }

}
