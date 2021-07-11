/*
 *  UCF COP3330 Summer 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Goodwin
 */

package ucf.assignments;


public class addToDoList {

    toDoList[] tdl = new toDoList[100];

public int addtolist(int number, String name){
    tdl[number] = new toDoList(name);
    number = number + 1;
    return number;
}

}
