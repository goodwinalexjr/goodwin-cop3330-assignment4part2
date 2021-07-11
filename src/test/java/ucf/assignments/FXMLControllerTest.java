/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FXMLControllerTest {

    @Test
    void newButtonClickedTDL() {
        // get current amount of numbers in the to do list
        //call the addtodolist class
        // add a new item to the to do list
        //get new value of items in the to do list
        //assert that there is one more in the to do list
    }

    @Test
    void edidButtonClickedTDL() {
        //get the current string for the to do list
        //call the edittodolist class
        //change the name with a known name
        //assert that the new name is the current name of the string
    }

    @Test
    void deleteButtonClickedTDL() {
        // get current amount of numbers in the to do list
        //call the removetodolist class
        // remove a new item to the to do list
        //get new value of numbers in the to do list
        //assert that there is one less in the to do list
    }

    @Test
    void addbuttonClicked() {
        //get the current amount of numbers of items in the list
        //call the additem function
        //get a new value of items from the todolistlist function
        //assert that there is one more in the items
    }

    @Test
    void removeButtonClicked() {
        //get the current amount of numbers of items in the list
        //call the removeitemlist class
        //remove an item to the list
        //get a new value of items
        //assert that there is one less in the items
    }

    @Test
    void editlistButtonClicked() {
        //get the current string for the to do list
        //call the edititem class
        //change the name with a known name
        //assert that the new name is the current name of the string
    }

    @Test
    void displayAllbuttonClicked() {
        //get the current value of all the items in a list
        //click the button
        //assert if all the values of items in the list is displayed
    }

    @Test
    void checkboxClicked() {
        //assert if an item is marked with a checkbox
        //click the checkbox
        //assert if it has changed
    }

    @Test
    void displayincompleteButtonClicked() {
        //get the current value of items not marked with a checkbox
        //click the button
        //assert if only those values are displayed
    }

    @Test
    void displaycompleteButtonClicked() {
        //get the current value of items marked with a checkbox
        //click the button
        //assert if only those values are displayed
    }

    @Test
    void exportlistButtonClicked() {
        //get the current list
        //call the export list class export one function
        //assert if there is a save file
    }

    @Test
    void exportalllistButtonClicked() {
        //call the export list class export all function
        //assert if there is a save file
    }

    @Test
    void importlistsButtonClicked() {
        //call the importfiles class
        //assert if there is new data
    }
}