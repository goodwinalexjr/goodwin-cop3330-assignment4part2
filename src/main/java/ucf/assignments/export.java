/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;

import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class export {
    //create a function that will save to the computer for a singele to do list
    //need to read in each item and then write to a file
    //seperate somehow???? thinking with a new line or space
    //figure out about bufferwriter and how to save with that

    public static void save(ObservableList<toDoListList> tdl, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file + ".tdl"));

        for(toDoListList todolistlist: tdl){
            bw.write(todolistlist.getTitle().toString());
            bw.newLine();
            bw.write(todolistlist.getDuedate().toString());
            bw.newLine();
            bw.write(todolistlist.getComplete().toString());
            bw.newLine();
            bw.write(todolistlist.getDescription().toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }
}
